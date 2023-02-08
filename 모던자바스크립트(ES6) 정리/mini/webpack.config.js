const path = require('path');
 
module.exports = {
    entry: {
        index : ['@babel/polyfill', './webapp/js/bundle/index.js'] // 빌드를 진행 하려는 파일 위치
        /*
        test1 : ['@babel/polyfill', './webapp/js/bundle/test1.js'], // 각각 파일로 빌드를 할 수 있짐만 비효율 적이므로 index.js 파일에 export 하여 한곳으로 빌드 추천
        test2: ['@babel/polyfill', './webapp/js/bundle/test2.js']
        */
    },
    output: { // 빌드 된 파일이 저장될 위치
        path: path.resolve(__dirname, './webapp/js/bundle'),
        filename: 'webpack.bundle.js', // filename : '[name].bundle.js',
        // library: "bundle", // 이름을 지정 할 경우 bundle.es6Code() 형태로 호출
        libraryTarget: "umd", // output.libraryTarget을 umd로 설정하면 모듈은 <script src=""> 로드 뿐만 아니라 모든 방식의 로더에서 사용할 수 있음
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            }
        ]
    },
    devtool: 'source-map',
    mode: 'development'
};