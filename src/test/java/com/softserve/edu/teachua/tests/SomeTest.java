package com.softserve.edu.teachua.tests;

import com.softserve.edu.teachua.data.Challengies;
import com.softserve.edu.teachua.data.ClubContents;
import com.softserve.edu.teachua.data.CommentContents;
import com.softserve.edu.teachua.pages.challenge.ChallengeTeachPage;
import com.softserve.edu.teachua.pages.challenge.YoutubeFrame;
import com.softserve.edu.teachua.pages.club.AdvancedClubPage;
import com.softserve.edu.teachua.pages.club.ClubComponent;
import com.softserve.edu.teachua.pages.club.ClubDetailsPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SomeTest extends TestRunner {

    private static Stream<Arguments> challengeTeachProvider() {
        return Stream.of(
                Arguments.of(Challengies.TO_LEARN_CHALLENGE)
        );
    }

    @ParameterizedTest(name = "{index} => challengeName={0}")
    @MethodSource("challengeTeachProvider")
    public void checkChallenge(Challengies challengeName) {
        YoutubeFrame youtubeFrame = loadApplication()
                .gotoChallengePage(challengeName, ChallengeTeachPage.class)
                .gotoYoutubeFrame();
        // TODO Task 1: assert the URL that the YouTube element points to.
        // Use youtubeFrame.getYoutubeLinkText() and the link stored for challengeName.
    }

    private static Stream<Arguments> clubProvider() {
        return Stream.of(
                Arguments.of(ClubContents.NEW_CADRE_CLUB),
                Arguments.of(ClubContents.VECTOR_CLUB)
        );
    }

    @ParameterizedTest(name = "{index} => clubContents={0}")
    @MethodSource("clubProvider")
    public void checkClubExist(ClubContents clubContents) {
        ClubComponent clubComponent = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .getClubContainer()
                .getClubComponentByPartialTitle(clubContents.getTitle());
        // TODO Task 2: assert the club title and a part of the description
        // from clubContents against clubComponent.
    }

    @ParameterizedTest(name = "{index} => clubContents={0}")
    @MethodSource("clubProvider")
    public void checkAdvancedSearch(ClubContents clubContents) {
        AdvancedClubPage advancedClubPage = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .gotoAdvancedClubPage();
        // TODO Task 2: walk pagination with advancedClubPage.nextClubPagination()
        // until the club from clubContents is present, then assert that it was found.
    }

    private static Stream<Arguments> commentProvider() {
        return Stream.of(
                Arguments.of(ClubContents.IT_EDUCATION_CLUB, CommentContents.FIRST_COMMENT)
        );
    }

    @ParameterizedTest(name = "{index} => clubContents={0}, commentContents={1}")
    @MethodSource("commentProvider")
    public void checkCommentExist(ClubContents clubContents, CommentContents commentContents) {
        ClubDetailsPage clubDetailsPage = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .getClubContainer()
                .getClubComponentByPartialTitle(clubContents.getTitle())
                .openClubDetailsPage();
        // TODO Task 3 (optional): assert that commentContents is present
        // in clubDetailsPage.getCommentContainer().
    }
}
