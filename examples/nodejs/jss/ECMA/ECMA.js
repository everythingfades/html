const baseURL = "localhost:3000"
const getArraySum = arr => arr.reduce((sum, item) => sum += item, 0)

export default {
    url: baseURL,
    getArraySum: getArraySum
}