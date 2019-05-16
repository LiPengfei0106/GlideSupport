## GlideSupport
#### 使用Glide+androidsvg+fresco实现加载GIF、SVG、WebP等多种格式的图片和动画文件。

**SVG**  [Glide](https://github.com/bumptech/glide)中给出了加载SVG的示例，通过自定义Module在Registry中注册新的处理对象，使用[androidsvg](http://bigbadaboom.github.io/androidsvg/)提供的方法来将InputStream转为SVG对象，然后把SVG对象转为PictureDrawable加载到目标target中。

**WebP** 参考[GlideWebpSupport](https://github.com/roths/GlideWebpSupport)，仿照Glide实现加载GIF图片的方式，使用[Fresco](https://github.com/facebook/fresco)的animated-webp来实现加载Webp图片