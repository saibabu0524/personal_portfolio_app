package com.example.personalportifolioapp

import com.example.personalportifolioapp.ui.theme.EducationDataClass

data class DeveloperProfileDataClass(
    var name: String = "Sai Babu",
    var jobTitle: String = "IOS Developer",
    var description: String = "",
    var profileImage: String = "",
    var skills: MutableList<String> = mutableListOf(),
    var education: MutableList<EducationDataClass> = mutableListOf(),
    var experience: MutableList<ExperienceDataClass> = mutableListOf(),
    var icons: Int = 0
)