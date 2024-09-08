const checkUserName = username => {
    return username.length >= 8
}

const checkPassword = password => {
    return password.length >= 8
}

module.exports = {
    checkUser: checkUserName,
    checkPass: checkPassword
}