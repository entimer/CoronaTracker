package com.entimer.coronatracker.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    fun getToday(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
        val todayCalendar = Calendar.getInstance().time
        return formatter.format(todayCalendar)
    }

    fun stringToCalendarWithTime(stringDate: String): Calendar {
        val list = stringDate.split("-")
        val calendar = Calendar.getInstance()
        calendar.set(list[0].toInt(), list[1].toInt(), list[2].toInt(), list[3].toInt(), list[4].toInt(), list[5].toInt())
        return calendar
    }

    fun compare2Dates(date1: String, date2: String): Long {
        val time1 = stringToCalendarWithTime(date1).timeInMillis
        val time2 = stringToCalendarWithTime(date2).timeInMillis
        return time1 - time2
    }

    fun getMonth(date: String): String {
        return date.split("-")[1]
    }

    fun getDate(date: String): String {
        return date.split("-")[2]
    }

    fun getChangedDate(date: String, amount: Int): String {
        val splited = date.split("-")
        val year = splited[0].toInt()
        val month = splited[1].toInt()
        val date = splited[2].toInt()

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month - 1)
        calendar.set(Calendar.DATE, date)

        calendar.add(Calendar.DATE, amount)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(calendar.time)
    }
}