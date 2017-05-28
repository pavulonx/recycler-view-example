package pl.rozen.swim.recyclerviewexample.models

import pl.rozen.swim.recyclerviewexample.domain.Album

/**
 * Created by rozen on 27.05.17.
 */
object DatabaseHelper {

    val albumsList:MutableList<Album> = prepareData()

    fun getAlbumAt(index: Int): Album {
        return albumsList[index]
    }

    fun removeAlbumAt(index: Int): Album {
        return albumsList.removeAt(index)
    }

    private fun prepareData(): MutableList<Album> {
        val albums = arrayListOf(
                Album("Got Your Six", "Five Finger Death Punch", "heavy metal", "2015", description = "Got Your Six is the sixth studio album by American heavy metal band Five Finger Death Punch. It was released on September 4, 2015 on the Prospect Park label.[2][3] Got Your Six sold 119,000 units to debut at No. 2 on the Billboard 200. The 114,000 in pure album sales made it the No. 1-selling album of the week and the band's best sales week to date. Got Your Six is also their third consecutive set to debut at No. 2."),
                Album("The Wrong Side of Heaven and the Righteous Side of Hell, Volume 1",
                        "Five Finger Death Punch", "heavy metal", "2013"),
                Album("The Wrong Side of Heaven and the Righteous Side of Hell, Volume 2",
                        "Five Finger Death Punch", "heavy metal", "2013"),
                Album("American Capitalist", "Five Finger Death Punch", "heavy metal", "2011"),
                Album("Nightmare", "Avenged Sevenfold", "heavy metal", "2010"),
                Album("Hail to the King", "Avenged Sevenfold", "heavy metal", "2013"),
                Album("The Stage", "Avenged Sevenfold", "heavy metal", "2016"),
                Album("Avenged Sevenfold", "Avenged Sevenfold", "heavy metal", "2017"),
                Album("Seal the Deal & Let's Boogie", "Volbeat", "alternative metal, heavy metal", "2016"),
                Album("Outlaw Gentlemen & Shady Ladies", "Volbeat", "alternative metal, heavy metal", "2013"),
                Album("Beyond Hell / Above Heaven", "Volbeat", "heavy metal", "2010"),
                Album("Guitar Gangsters & Cadillac Blood", "Volbeat", "alternative metal", "2008"),
                Album("Rock the Rebel / Metal the Devil", "Volbeat", "heavy metal", "2007"),
                Album("The Strength / The Sound / The Songs", "Volbeat", "heavy metal", "2005")
        )
        return albums
    }


}