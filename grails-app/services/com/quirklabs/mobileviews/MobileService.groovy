package com.quirklabs.mobileviews

class MobileService {

    static boolean isMobile( request ) {

        if( !request ) return false

        def device = request.getAttribute( 'currentDevice' )

        if( !device ) return false

        boolean mobile = device.isMobile()

        if( mobile ) {
            def userAgent = request.getHeader( 'User-Agent' )
            if( userAgent ) {
                if( userAgent?.contains( 'iPad' ) ) {
                    mobile = false
                }
                else if( userAgent?.contains( 'Android' ) && !userAgent?.contains( 'Mobile' ) ) {
                    mobile = false
                }
            }
        }

        return mobile
    }
}
