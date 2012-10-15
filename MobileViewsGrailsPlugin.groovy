class MobileViewsGrailsPlugin {
    // the plugin version
    def version = "1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [springMobile:'0.4']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Grails Mobile Views Plugin" // Headline display name of the plugin
    def author = "Matthew de Nobrega"
    def authorEmail = "matthew.denobrega@quirk.biz"
    def description = '''\
Uses WURFL to switch to views in a mobile folder for mobile devices
'''
    def documentation = "https://github.com/quirklabs/grails-mobile-views"
    def license = "APACHE"
    def organization = [ name: "Quirk Labs", url: "http://www.quirklabs.co.za" ]
    def scm = [ url: "https://github.com/quirklabs/grails-mobile-views" ]
}
