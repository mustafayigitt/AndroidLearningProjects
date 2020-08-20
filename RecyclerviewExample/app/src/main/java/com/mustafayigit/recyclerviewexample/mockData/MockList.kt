package com.mustafayigit.recyclerviewexample.mockData

import com.mustafayigit.recyclerviewexample.model.ProfileData

/**
 * Created By MUSTAFA
 * on 26/03/2020
 */
object MockList {
    fun getMockData(): List<ProfileData> {
        val profileData = ProfileData(
            "https://cdn.webtekno.com/media/cache/content_detail_v2/article/29121/android-kotlin-1495097437.jpg",
            "User Full Name",
            "User Department"
        )
        
        val profileDataList: ArrayList<ProfileData> = ArrayList()
        repeat(20){
            profileDataList.add(profileData)            
        }
        return profileDataList

    }
}
