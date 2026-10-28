(function () {
  const script = document.currentScript;
  const apiUrl = script?.dataset.apiUrl;
  const form = document.getElementById('newsletter-form');
  const emailInput = document.getElementById('newsletter-email');
  const websiteInput = document.getElementById('newsletter-website');
  const messageEl = document.getElementById('newsletter-message');
  const submitBtn = document.getElementById('newsletter-submit');

  if (!apiUrl || !form || !emailInput || !messageEl || !submitBtn) {
    return;
  }

  function setMessage(text, isError) {
    messageEl.textContent = text;
    messageEl.style.color = isError ? '#b00020' : '#2e7d32';
  }

  function isValidEmail(value) {
    if (!value || value.length > 254) {
      return false;
    }
    var at = value.lastIndexOf('@');
    if (at <= 0 || at >= value.length - 1) {
      return false;
    }
    var local = value.slice(0, at);
    var domain = value.slice(at + 1);
    if (local.length > 64 || domain.length > 253) {
      return false;
    }
    if (/^\./.test(local) || /\.$/.test(local) || local.indexOf('..') >= 0) {
      return false;
    }
    if (/^\./.test(domain) || /\.$/.test(domain) || domain.indexOf('..') >= 0) {
      return false;
    }
    if (!/^[a-z0-9!#$%&'*+/=?^_`{|}~.-]+$/i.test(local)) {
      return false;
    }
    var labels = domain.split('.');
    if (labels.length < 2 || labels[labels.length - 1].length < 2) {
      return false;
    }
    return labels.every(function (label) {
      return /^[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?$/i.test(label);
    });
  }

  form.addEventListener('submit', async function (event) {
    event.preventDefault();
    const email = emailInput.value.trim().toLowerCase();
    if (!email) {
      setMessage('请输入邮箱地址。', true);
      return;
    }
    if (!isValidEmail(email)) {
      setMessage('邮箱格式无效，请输入合法的邮件地址。', true);
      return;
    }

    submitBtn.disabled = true;
    setMessage('提交中…', false);

    try {
      const response = await fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          email: email,
          website: websiteInput ? websiteInput.value : '',
        }),
      });
      const data = await response.json().catch(function () { return {}; });

      if (response.ok) {
        if (data.alreadyConfirmed) {
          setMessage('该邮箱已订阅，无需重复确认。', false);
        } else {
          setMessage('确认邮件已发送，请查收并完成订阅。', false);
          form.reset();
        }
      } else {
        setMessage(data.error || '订阅失败，请稍后再试。', true);
      }
    } catch (_error) {
      setMessage('网络错误，请稍后再试。', true);
    } finally {
      submitBtn.disabled = false;
    }
  });
})();
