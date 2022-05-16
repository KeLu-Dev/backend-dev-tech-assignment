### Technical Assessment

### Docker

DockerFile is located inside src. 
Maven build is included in the Dockerfile so only the following commands are required:  

'docker build -t restful_jukebox_app.jar .'

'docker run -p 8080:8080 restful_jukebox_app.jar'

### Implemented API

Endpoints: 

GET -> /jukeboxapi/jukeboxesBySetting -> for getting a list of jukeboxes that support a Setting

Parameters: 

`settingId` - String  - id of a Setting to search for    - (required)

`model`     - String  - filter by model name             - (optional)

`offset`    - Integer - specifies index of start of page - (optional)

`limit`     - Integer - specifies the page size          - (optional)

### Example calls to run via Postman: 

Basic call with Valid settingID:
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8

settingId and model: 
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&model=angelina

settingId, model and limit:
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&limit=2

settingId, model and offset:
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&offset=2

settingId, offset and limit:
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&offset=2&limit=2

settingID, offset, limit, and model:
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&offset=1&limit=5&model=angelina

### Example faulty calls to test via Postman: 

Missing Required Param(settingId): 
http://localhost:8080/jukeboxapi/jukeboxesBySetting?offset=1&limit=5&model=angelina

No Setting matches given SettingId: 
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=IdontExist!&offset=1&limit=5&model=angelina

Model DNE: 
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=358a044e-decc-47cc-aaf1-e2253a00998e&model=fakename

Faulty Offset or limit value: 
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&offset=1&limit=-1&model=angelina

Faulty type for Offset or limit: 
http://localhost:8080/jukeboxapi/jukeboxesBySetting?settingId=207797de-5857-4c60-a69b-80eea28bcce8&offset=a&limit=1&model=angelina


### Original Problem description

Imagine you are building a web application to remote control Jukebox settings. Depending on what components (hardware modules) a jukebox has, it may or may not support a setting (a key-value pair). For example a jukebox with "LED panel" component supports `animation_type` setting or a jukebox which does not have a "money_receiver" component does not support `currency` setting. 

## The assignment

You need to create a REST API with a single GET endpoint which returns a paginated list of jukeboxes that suppport a given setting id. It should support following query parameters:

 - `settingId` - setting id (required)
 - `model` - filter by model name (optional)
 - `offset` - specifies at what index start the page (optional)
 - `limit` - specifies the page size (optional)

Create a production-ready implementation and make sure you use the mocked APIs listed below.  
_Hint_: docs / error codes / tests / API docs  
Bonus points: dockerize you application.

## Important notes

You need to make use of the following "mocked" APIs which will return jukebox and settings data.

### Jukebox API

Returns a list of jukeboxes with information about them:

**GET** `http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes`:

```js
[{
  "id": "5ca94a8ac470d3e47cd4713c",
  "model": "fusion",
  "components": [{
    "name": "led_panel"
  }, {
    "name": "amplifier"
  }]
},
//...
]
```
 
### Settings API

Returns a list of all the available jukebox settings. Each setting contains a list of required components which a jukebox should have in order to support the setting.

**GET** `http://my-json-server.typicode.com/touchtunes/tech-assignment/settings`:

```js
{
  "settings": [{
    "id": "e9869bbe-887f-4d0a-bb9d-b81eb55fbf0a",
    "requires": ["camera", "speaker", "pcb"]
  }, {
    "id": "db886f37-16e3-4a55-80e4-cfffc9e4e464",
    "requires": ["touchscreen", "money_pcb", "led_panel", "money_receiver"]
  },
  //...
  ]
}
```

**Note** that setting is considered to be supported if jukebox has _all_ required components.
