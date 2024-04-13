# tcmb-client

Java SDK that connects to central bank (TCMB) and provides TCMB related data. 

To use it (not ready yet) as a maven dependency, add the following;

```
<dependency>
    <groupId>com.zanitech.sdk</groupId>
    <artifactId>tcmb-client</artifactId>
    <version>1.0.0</version>
</dependency>
```
## Example Usage
To get instant foreign exchange rates;
```
TcmbClient tcmbClient = new TcmbClient();
ForexRateOutput forexRateOutput = tcmbClient.forex().getRates();
```

## Features to be added
- Bank and branches look up data
- Evds client

## Main contributors
- Esat Koç