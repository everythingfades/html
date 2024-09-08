const baseURL = "localhost:3000"
const getArraySum = arr => arr.reduce((sum, item) => sum += item, 0)

module.exports = {
    url: baseURL,
    getArraySum: getArraySum
}