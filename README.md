# Thank You For The Opportunity
## brief description
this app has been implemented with clean architecture which is one the top standard architectures for android projects. Meets SOLID principles perfectly and testing modules easy. the main modules for this app are 3 modules, each modules implements one layer of the architecture: 

1- Data

2-Domain

3-Presentation

1- DATA: the main tools for the data module is :
Hilt, Retroft, Gson, Junit, Mockk 

there are mappers to implement loose coupling in code and several data class types for every purpose.

 2- DOMAIN: the main tools for domain module is :

Hilt,  Junit, Mockk, Timber, Flow, Coroutines

there are two use cases in-order to access each method in the main repository in the data module. instead of injecting the whole repository into every viewModel we separate every main use in a single use case. 

3- PRESENTATION: the main tools for presentation layer is : 
compose, accompanist, Glide, Hilt, Junit 

in these layer we take advantage of jetpack compose by creating auto-darak & light theme, material components, hiltViewModels, color palettes and etc.

### also a vide demo of the application: 





https://github.com/narcis-dpr/Giphy-Clean-Architecture/assets/29674637/ea26cb87-9f09-4bdb-99ba-7dbefb40a2c6




