## 资料
[官网:http://tess4j.sourceforge.net/](http://tess4j.sourceforge.net/)

[官网:http://tess4j.sourceforge.net/tutorial/](http://tess4j.sourceforge.net/tutorial/)

> tess4j默认嵌入了windows环境的动态库,其他平台需要安装tesseract环境.

## Question1
tess4j默认带有win32-x86-64 和win32-86 两个文件夹分别存放着64位和32位动态链接库，但是唯独没有Linux的动态链接库.

所以linux环境默认时不能使用test4j的.

### 1. 解决
[其他环境安装指南:https://github.com/tesseract-ocr/tesseract/wiki/Compiling](https://github.com/tesseract-ocr/tesseract/wiki/Compiling)

指南包含一下内容:

- apt install on ubuntu18 with train tools

- Install elsewhere / without root

> centos7上安装, 安装3.05版本即可, 对应Leptonica版本1.74.0

> 记得先装leptonica, 编译安装 without root

github上指南写的有些简单,整理一下

[Leptonica Releases](https://github.com/DanBloomberg/leptonica/releases?after=1.74.1)

```sbtshell
# 1.找到Leptonica版本1.74.0,编译安装
wget https://github.com/DanBloomberg/leptonica/archive/1.74.0.tar.gz
# 2.解压编译安装
./autogen.sh
LIBLEPT_HEADERSDIR=$HOME/local/include ./configure \
  --prefix=$HOME/local/ --with-extra-libraries=$HOME/local/lib
make
make install
# 3.同上下载leptonica4.0.5
./autobuild   # 版本不同,命令可能不同
./configure --prefix=$HOME/local/
make
make install
# 4.配置环境变量PKG_CONFIG_PATH(别忘记哦)
export PKG_CONFIG_PATH=$HOME/local/lib/pkgconfig

```

### 2. 参考
[linux系统如何使用tess4j（java）进行ocr图片文字识别](https://blog.csdn.net/zhongshanb/article/details/72731487)

[Linux——完全安装Tesseract环境](https://blog.csdn.net/u012476249/article/details/53423193)


### 3. 注意点
- 不同的Tesseract版本对应不同的Leptonica依赖包.
详细见参考:


- windows环境没有详细看, 需要的话看github的环境指南

- centos7上安装, 安装3.05版本即可(编译安装的版本,也是最新稳定版本), 对应Leptonica版本1.74.0

- 4.0 加入了LSTM

- java的版本tess4j是否需要对应:先对应使用吧

[环境安装指南:https://github.com/tesseract-ocr/tesseract/wiki/Compiling](https://github.com/tesseract-ocr/tesseract/wiki/Compiling)

[Linux——完全安装Tesseract环境](https://blog.csdn.net/u012476249/article/details/53423193)


