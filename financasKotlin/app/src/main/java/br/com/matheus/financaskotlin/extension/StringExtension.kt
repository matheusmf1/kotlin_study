package br.com.matheus.financaskotlin.extension

fun String.shrinkContent( limit: Int ) : String {

  if ( this.length > 14 )
    return "${this.substring( 0,14 )}..."

  return this

}