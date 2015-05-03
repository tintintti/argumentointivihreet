#Argumentointivirhe-peli

**Aihe:** Peli, joka arpoo pelaajalle argumentin ja pelaajan tulee valita vaihtoehdoista mikä argumentointivirhe väitteessä on. Nopeasta vastaamisesta voi saada lisäpisteitä.

Pelin loputtua pisteet tallennetaan highscore-listalle ja korkeimmat pistemäärät näytetään pelaajalle. Highscore-listaa voi katsoa myös erikseen.

**Käyttäjät:** pelaaja

**Käyttäjän toiminnot:**
  - tarkastele highscorea
  - aloita peli
  - valitse vastausvaihtoehto


**Rakennekuvaus**

Peli-luokka tarjoaa huolehtii vastaamisesta, pelaajalle pisteiden lisäämisestä, hakee väitteet ja vastausvaihtoehdot Tiedostonlukija-luokan ilmentymältä ja huolehtii Highscore-luokan ilmentymän avulla Highscore-listan päivittämisestä ja näyttämisestä.

Ajastin-luokka laskee kauan pelaajalla menee aikaa vastaamiseen ja välittää tiedon Pelille, kun Peli sitä kysyy.

HighScore-luokka huolehtii HS-listan päivittämisestä ja lukemisesta HighScoreLukija- ja HighScoreKirjoittaja-luokkien avulla.

Pelaaja-luokka hoitaa pelaajan tietojen (nimimerkki ja pistetilanne) tallentamisen.

Vaite-luokka hoitaa väitteiden, niiden sanojien sekä oikean vastauksen tallentamisen.

Graafinen käyttöliittymä koostuu useista näkymistä, jotka on järjestetty CardLayoutiin ja joita päivitetään tarvittaessa. 
