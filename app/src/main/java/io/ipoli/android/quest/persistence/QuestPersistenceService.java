package io.ipoli.android.quest.persistence;

import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.SortedMap;

import io.ipoli.android.app.persistence.PersistenceService;
import io.ipoli.android.quest.data.Quest;
import io.ipoli.android.quest.data.QuestReminder;

/**
 * Created by Venelin Valkov <venelin@curiousily.com>
 * on 1/7/16.
 */
public interface QuestPersistenceService extends PersistenceService<Quest> {

    void listenForInboxQuests(OnDataChangedListener<List<Quest>> listener);

    void listenForPlannedNonAllDayBetween(LocalDate startDate, LocalDate endDate, OnDataChangedListener<SortedMap<LocalDate, List<Quest>>> listener);

    void findAllCompletedNonAllDayBetween(LocalDate startDate, LocalDate endDate, OnDataChangedListener<List<Quest>> listener);

    void findAllPlannedAndStarted(OnDataChangedListener<List<Quest>> listener);

    void findAllIncompleteFor(LocalDate date, OnDataChangedListener<List<Quest>> listener);

    void listenForAllNonAllDayForDate(LocalDate currentDate, OnDataChangedListener<List<Quest>> listener);

    void findAllNonAllDayForDate(LocalDate currentDate, OnDataChangedListener<List<Quest>> listener);

    void listenForAllNonAllDayCompletedForDate(LocalDate currentDate, OnDataChangedListener<List<Quest>> listener);

    void listenForAllNonAllDayIncompleteForDate(LocalDate currentDate, OnDataChangedListener<List<Quest>> listener);

    void findAllUpcomingForRepeatingQuest(LocalDate scheduledPeriodStart, String repeatingQuestId, OnDataChangedListener<List<Quest>> listener);

    void countAllCompletedWithPriorityForDate(int priority, LocalDate date, OnDataChangedListener<Long> listener);

    void findQuestRemindersAtStartTime(long startTime, OnDataChangedListener<List<QuestReminder>> listener);

    void findNextReminderTime(OnDataChangedListener<Long> listener);

    void listenForAllIncompleteOrMostImportantForDate(LocalDate now, OnDataChangedListener<List<Quest>> listener);

    void save(List<Quest> quests);
}