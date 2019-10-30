package com.example.tairo.gitbubapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("archive_url")
    private String archiveUrl;
    @SerializedName("assignees_url")
    private String assigneesUrl;
    @SerializedName("blobs_url")
    private String blobsUrl;
    @SerializedName("branches_url")
    private String branchesUrl;
    @SerializedName("collaborators_url")
    private String collaboratorsUrl;
    @SerializedName("comments_url")
    private String commentsUrl;
    @SerializedName("commits_url")
    private String commitsUrl;
    @SerializedName("compare_url")
    private String compareUrl;
    @SerializedName("contents_url")
    private String contentsUrl;
    @SerializedName("contributors_url")
    private String contributorsUrl;
    @SerializedName("deployments_url")
    private String deploymentsUrl;
    @SerializedName("description")
    private String description;
    @SerializedName("downloads_url")
    private String downloadsUrl;
    @SerializedName("events_url")
    private String eventsUrl;
    @SerializedName("fork")
    private Boolean fork;
    @SerializedName("forks_url")
    private String forksUrl;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("git_commits_url")
    private String gitCommitsUrl;
    @SerializedName("git_refs_url")
    private String gitRefsUrl;
    @SerializedName("git_tags_url")
    private String gitTagsUrl;
    @SerializedName("hooks_url")
    private String hooksUrl;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("id")
    private Long id;
    @SerializedName("issue_comment_url")
    private String issueCommentUrl;
    @SerializedName("issue_events_url")
    private String issueEventsUrl;
    @SerializedName("issues_url")
    private String issuesUrl;
    @SerializedName("keys_url")
    private String keysUrl;
    @SerializedName("labels_url")
    private String labelsUrl;
    @SerializedName("languages_url")
    private String languagesUrl;
    @SerializedName("merges_url")
    private String mergesUrl;
    @SerializedName("milestones_url")
    private String milestonesUrl;
    @SerializedName("name")
    private String name;
    @SerializedName("notifications_url")
    private String notificationsUrl;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("private")
    private Boolean isPrivate;
    @SerializedName("pulls_url")
    private String pullsUrl;
    @SerializedName("releases_url")
    private String releasesUrl;
    @SerializedName("stargazers_url")
    private String stargazersUrl;
    @SerializedName("statuses_url")
    private String statusesUrl;
    @SerializedName("subscribers_url")
    private String subscribersUrl;
    @SerializedName("subscription_url")
    private String subscriptionUrl;
    @SerializedName("tags_url")
    private String tagsUrl;
    @SerializedName("teams_url")
    private String teamsUrl;
    @SerializedName("trees_url")
    private String treesUrl;
    @SerializedName("url")
    private String url;

    public User() {
    }


    protected User(Parcel in) {
        archiveUrl = in.readString();
        assigneesUrl = in.readString();
        blobsUrl = in.readString();
        branchesUrl = in.readString();
        collaboratorsUrl = in.readString();
        commentsUrl = in.readString();
        commitsUrl = in.readString();
        compareUrl = in.readString();
        contentsUrl = in.readString();
        contributorsUrl = in.readString();
        deploymentsUrl = in.readString();
        description = in.readString();
        downloadsUrl = in.readString();
        eventsUrl = in.readString();
        byte tmpFork = in.readByte();
        fork = tmpFork == 0 ? null : tmpFork == 1;
        forksUrl = in.readString();
        fullName = in.readString();
        gitCommitsUrl = in.readString();
        gitRefsUrl = in.readString();
        gitTagsUrl = in.readString();
        hooksUrl = in.readString();
        htmlUrl = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        issueCommentUrl = in.readString();
        issueEventsUrl = in.readString();
        issuesUrl = in.readString();
        keysUrl = in.readString();
        labelsUrl = in.readString();
        languagesUrl = in.readString();
        mergesUrl = in.readString();
        milestonesUrl = in.readString();
        name = in.readString();
        notificationsUrl = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        byte tmpIsPrivate = in.readByte();
        isPrivate = tmpIsPrivate == 0 ? null : tmpIsPrivate == 1;
        pullsUrl = in.readString();
        releasesUrl = in.readString();
        stargazersUrl = in.readString();
        statusesUrl = in.readString();
        subscribersUrl = in.readString();
        subscriptionUrl = in.readString();
        tagsUrl = in.readString();
        teamsUrl = in.readString();
        treesUrl = in.readString();
        url = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(archiveUrl);
        dest.writeString(assigneesUrl);
        dest.writeString(blobsUrl);
        dest.writeString(branchesUrl);
        dest.writeString(collaboratorsUrl);
        dest.writeString(commentsUrl);
        dest.writeString(commitsUrl);
        dest.writeString(compareUrl);
        dest.writeString(contentsUrl);
        dest.writeString(contributorsUrl);
        dest.writeString(deploymentsUrl);
        dest.writeString(description);
        dest.writeString(downloadsUrl);
        dest.writeString(eventsUrl);
        dest.writeByte((byte) (fork == null ? 0 : fork ? 1 : 2));
        dest.writeString(forksUrl);
        dest.writeString(fullName);
        dest.writeString(gitCommitsUrl);
        dest.writeString(gitRefsUrl);
        dest.writeString(gitTagsUrl);
        dest.writeString(hooksUrl);
        dest.writeString(htmlUrl);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(issueCommentUrl);
        dest.writeString(issueEventsUrl);
        dest.writeString(issuesUrl);
        dest.writeString(keysUrl);
        dest.writeString(labelsUrl);
        dest.writeString(languagesUrl);
        dest.writeString(mergesUrl);
        dest.writeString(milestonesUrl);
        dest.writeString(name);
        dest.writeString(notificationsUrl);
        dest.writeParcelable(owner, flags);
        dest.writeByte((byte) (isPrivate == null ? 0 : isPrivate ? 1 : 2));
        dest.writeString(pullsUrl);
        dest.writeString(releasesUrl);
        dest.writeString(stargazersUrl);
        dest.writeString(statusesUrl);
        dest.writeString(subscribersUrl);
        dest.writeString(subscriptionUrl);
        dest.writeString(tagsUrl);
        dest.writeString(teamsUrl);
        dest.writeString(treesUrl);
        dest.writeString(url);
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
