document.getElementById('form-login').addEventListener('submit', function (event) {
    event.preventDefault();
    login();
});

function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    axios.post('/api/auth/login', {
        email: email,
        password: password
    })
        .then(function (response) {
            toastr.success('Đăng nhập thành công!');
            window.location.href = '/';
        })
        .catch(function (error) {
            toastr.error('Đăng nhập thất bại, kiểm tra lại thông tin đăng nhập!');
        });
}