package pl.rozen.swim.recyclerviewexample.domain

class Album(val title: String,
            val author: String,
            val genre: String,
            val year: String,
            val trackList: List<String> = ArrayList<String>()) {

    override fun toString(): String {
        return "Album(title='$title', author='$author', genre='$genre', year='$year')"
    }
}