# FireBase-Auth
Autenticação e login de utilizadores usando o jetpack compose MVVM

## comece por configurar o ambiente firebase e a app, siga as intruções do link https://github.com/momed003/FireBase-JetPack.git
### Na opção tool ao "Firebase", ao invés de selecionar realtime db, selecione authentication
### após configurar o ambiente, defina o metodo de autenticação no firebase, para este prjecto sera usado email e senha
### configure no seu lib.version.toml
hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt" }
hilt-compiler = { module = "com.google.dagger:hilt-compiler", version.ref = "hilt" }
hilt-gradle-plugin = { module = "com.google.dagger:hilt-android-gradle-plugin", version.ref = "hilt" }
lifecycle-viewmodel = { module = "androidx.lifecycle:lifecycle-viewmodel-ktx", version = "2.8.7" }
