const path = require("path")
const HtmlWebpackPlugin = require("html-webpack-plugin")
const MiniCssExtractPlugin = require("mini-css-extract-plugin")
const CssMinimizerPlugin = require('css-minimizer-webpack-plugin')
const webpack = require("webpack")
const config = {
    // mode: "development",
    entry: path.resolve(__dirname, "./src/login/index"),
    devtool: "inline-source-map",
    output: {
        path: path.resolve(__dirname, "dist"),
        filename: "./login/index.js",
        clean: true // 生成打包内容之前先清空输出目录
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.resolve(__dirname, "public/login.html"),
            filename: path.resolve(__dirname, "dist/login/index.html"),
            useCdn: process.env.NODE_ENV === "production"
        }),
        new MiniCssExtractPlugin({
            filename: "./login/index.css"
        }),
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify(process.env.NODE_ENV)
        })
    ],
    module: {
        rules: [
            {
                test: /\.css$/i,
                use: [process.env.NODE_ENV === "development" ? "style-loader" : MiniCssExtractPlugin.loader, "css-loader"]
            },
            {
                test: /\.less$/i,
                use: [
                    process.env.NODE_ENV === "development" ? "style-loader" : MiniCssExtractPlugin.loader,
                    'css-loader',
                    'less-loader',
                ],
            },
            {
                test: /\.(png|jpg|jpeg|gif)$/i,
                type: 'asset',
                generator: {
                    filename: 'assests/[hash][ext][query]'
                }
            }
        ]
    },
    optimization: {
        minimizer: [
            // 在webpack@5中可以使用 ... 语法扩展现有的minimizer(即
            // terser-webpack-plugin插件),将下一行取消注释(保证JS代码还能被压缩)
            `...`,
            new CssMinimizerPlugin(),
        ]
    },
    resolve: {
        alias: {
            "@": path.resolve(__dirname, "src")
        }
    }
}
if (process.env.NODE_ENV === "development"){
    config.devtool = "inline-source-map"
}
if (process.env.NODE_ENV === "production"){
    config.externels = {
        "bootstrap/dist/css/bootstrap.css": "bootstrap",
        // import "bootstrap/dist/css/bootstrap.min.css"
        "axios": "axios",
        // import axios from "axios"
    }
}
module.exports = config