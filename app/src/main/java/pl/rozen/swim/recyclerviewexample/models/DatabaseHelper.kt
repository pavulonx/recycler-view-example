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
                Album("Got Your Six", "Five Finger Death Punch", "heavy metal", "2015"),
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