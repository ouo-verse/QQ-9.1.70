package x6;

import NS_BG_VOICE_LOGIC_APP.BGFM;
import NS_BG_VOICE_LOGIC_APP.BGMusic;
import NS_BG_VOICE_LOGIC_APP.BGVoice;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import NS_MOBILE_FEEDS.FunnySpace;
import NS_MOBILE_FEEDS.FunnySpaceAction;
import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_MAIN_PAGE.mobile_main_page_rsp;
import NS_MOBILE_MAIN_PAGE.s_appinfo;
import NS_MOBILE_MAIN_PAGE.s_campus_qz;
import NS_MOBILE_MAIN_PAGE.s_count;
import NS_MOBILE_MAIN_PAGE.s_friend_ship;
import NS_MOBILE_MAIN_PAGE.s_friendreq;
import NS_MOBILE_MAIN_PAGE.s_gamebar_pk_banner;
import NS_MOBILE_MAIN_PAGE.s_limit_page_card;
import NS_MOBILE_MAIN_PAGE.s_limit_page_card_item;
import NS_MOBILE_MAIN_PAGE.s_mainPageTabItem;
import NS_MOBILE_MAIN_PAGE.s_main_page;
import NS_MOBILE_MAIN_PAGE.s_profile;
import NS_MOBILE_MAIN_PAGE.s_question;
import NS_MOBILE_MAIN_PAGE.s_red_comm;
import NS_MOBILE_MAIN_PAGE.s_red_info;
import NS_MOBILE_MAIN_PAGE.s_sq_mainpage_switch;
import NS_MOBILE_MAIN_PAGE.s_tab_list;
import NS_MOBILE_MAIN_PAGE.s_urge_publish_info;
import NS_MOBILE_MAIN_PAGE.s_user;
import NS_MOBILE_MAIN_PAGE.s_visit;
import NS_MOBILE_MUSIC.MusicInfo;
import NS_NEXTRADIO_QZONEBGMUSIC.BGMusicForQzone;
import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import NS_QMALL_COVER.MainpageQzmallDeco;
import NS_QMALL_COVER.StrangerSkin;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Pair;
import com.qzone.album.data.model.RedInfo;
import com.qzone.common.account.LoginData;
import com.qzone.homepage.business.model.EntranceItem;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.qzone.homepage.business.model.LimitPageInfoCardItem;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.homepage.ui.component.newpanel.HomePanelItem;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.personalize.music.model.UserMusicInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.util.l;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final String DATA = "data";
    public static final int GENDER_FEMALE = 0;
    public static final int GENDER_MALE = 1;
    public static final int RELATIONSHIP_CREDIT_LOW = 9;
    public static final int RELATIONSHIP_FRIEND_NEEDANSWER = 4;
    public static final int RELATIONSHIP_FRIEND_NOGEGIST = 7;
    public static final int RELATIONSHIP_FRIEND_NOTPASS = 3;
    public static final int RELATIONSHIP_FRIEND_PASS = 1;
    public static final int RELATIONSHIP_LOG_OFF = 10;
    public static final int RELATIONSHIP_NOTFRIEND_NEEDANSWER = 6;
    public static final int RELATIONSHIP_NOTFRIEND_NOREGIST = 8;
    public static final int RELATIONSHIP_NOTFRIEND_NOTPASS = 5;
    public static final int RELATIONSHIP_NOTFRIEND_PASS = 2;
    public static final int RELATIONSHIP_SELF = 0;
    public static final String TYPE_DATA = "BLOB";
    public static final String TYPE_UIN = "TEXT UNIQUE";
    public static final String UIN = "uin";
    public int age;
    public int albumRedCount;
    public ArrayList<BroadcastMusicInfo> allFmBroadCastList;
    public ArrayList<UserMusicInfo> allFmList;
    public ArrayList<UserMusicInfo> allMusicList;
    public int appMessageCount;
    public boolean askForFriend;
    public String askForFriendMsg;
    public String astro;
    public int birthdayCount;
    public int blogCount;
    public int blogRedCount;
    public String city;
    public String country;
    public int customType;
    public ArrayList<EntranceItem> entranceItems;
    public long familyAvatarUin;
    public String familyAvatarUrl;
    public String familyDescription;
    public String familyTraceInfo;
    public long fansCount;
    public String fansExpr;
    public long followCount;
    public String footerBannerBackgroundUrl;
    public String footerBannerJumpUrl;
    public String footerBannerTraceInfo;
    public int friendRequestCount;
    public int friendRequestNewCount;
    public int friendship;
    public String friendshipJumpUrl;
    public ArrayList<FunnySpaceModel> funnySpaceModels;
    public int gender;
    public String guestCustomIconUrl;
    public boolean hasFooterBanner;
    public String hostCustomIconUrl;
    public int isAnnualVip;
    public boolean isBlocked;
    public boolean isBothFriend;
    public boolean isCertification;
    public boolean isDisplayNameSet;
    public boolean isExcluded;
    public boolean isFollowed;
    public boolean isFriend;
    public boolean isHostFollowGrayUsr;
    public boolean isOpenFollow;
    public boolean isRecipientYellowBanner;
    public boolean isReverseBlack;
    public boolean isShowMyFriends;
    public boolean isShowWeishi;
    public boolean isSpecialCare;
    public boolean isSpecialFollowed;
    public boolean isSpecialFollowedPush;
    public boolean isVip;
    public boolean isVisitorFollowGrayUsr;
    public String jumpUrlForClickStrangerCover;
    public ArrayList<LimitPageInfoCardItem> limitPageInfoCardItems;
    public int loverSpaceCount;
    public ArrayList<HomePanelItem> mPanelHideList;
    public ArrayList<HomePanelItem> mPanelShowList;
    public ArrayList<HomePanelItem> mTopPanelShowList;
    public int messageCount;
    public long myFriendsAvartarUin;
    public String myFriendsAvatarText;
    public String myFriendsIconUrl;
    public String myFriendsJumpUrl;
    public String myFriendsTitle;
    public String name;
    public String nickName;
    public int photoCount;
    public byte playMode;
    public String province;
    public String qzoneName;
    public Map<Integer, String> rawPromptMsg;
    public int refuseVisitorCount;
    public int relationShip;
    public String relationShipMsg;
    public String share_bg_url;
    public boolean showFamilyRedDot;
    public int shuoshuoCount;
    public String spaceDesc;
    public d strangerDecorate;
    public long uin;
    public QZoneUrgePublishInfo urgePublishInfo;
    public String vipLeftDays;
    public int vipLevel;
    public int vipType;
    public int visitorCount;
    public int visitorNewCount;
    public byte wifiAutoPlayFlag;
    public int yellowDiamondCount;

    /* renamed from: d, reason: collision with root package name */
    private static int[] f447257d = {4, 3, 2, 1, 0};
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new b();
    public Bundle promptMsg = new Bundle();
    public ArrayList<String> questionList = new ArrayList<>();
    public ArrayList<User> visitorList = new ArrayList<>();
    public ArrayList<RedInfo> birthdayList = new ArrayList<>();
    public ArrayList<RedInfo> loverSpaceList = new ArrayList<>();
    public ArrayList<User> friendRequestList = new ArrayList<>();
    public boolean needShowSummaryInfo = true;
    public ArrayList<PictureItem> photoList = new ArrayList<>();
    public byte greenDiamondFlag = 0;
    public boolean musicCanPlay = true;
    public int allMusicNums = 0;
    public int is_in_visitor_notify_list = 0;
    public boolean isLoverZoneUser = false;
    public int starVipStatus = 0;
    public int starVipLevel = 0;
    public boolean isStarAnnualVip = false;
    public boolean isHighStarVip = false;
    public int comVipType = 0;
    public int comViplevel = 0;
    public boolean isComAnnualVip = false;
    public boolean isComAnnualVipEver = false;
    public String personalizedYellowVipUrl = null;
    public String vipurl = null;
    public int isCampusUser = 0;
    public int unreadMood = 0;
    public int unreadMessage = 0;
    public int bgVoiceType = -1;
    public byte loopPlaybackType = 0;
    public int brandFlag = 0;
    public boolean isOpenMsgBoard = false;
    public boolean isCustomDiamondUser = false;
    public String customDiamondUrl = "";
    public boolean isShowFamily = false;
    public String familyUrl = "";
    public String jumpUrlParamsForLoveZone = "";
    public long funnySpaceTotalCount = 0;
    public int userType = 0;
    public int moreNewCount = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: x6.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11531a implements Comparator<EntranceItem> {
        C11531a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EntranceItem entranceItem, EntranceItem entranceItem2) {
            int i3 = entranceItem.order;
            int i16 = entranceItem2.order;
            if (i3 < i16) {
                return -1;
            }
            if (i3 > i16) {
                return 1;
            }
            int i17 = entranceItem.redId;
            int i18 = entranceItem2.redId;
            if (i17 < i18) {
                return -1;
            }
            return i17 > i18 ? 1 : 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements IDBCacheDataWrapper.a<a> {
        b() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("data"));
            if (blob == null) {
                return null;
            }
            a aVar = new a();
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                aVar.readFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
            return aVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("data", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 17;
        }
    }

    a() {
    }

    private void B0(Parcel parcel) {
        parcel.writeInt(this.photoCount);
        parcel.writeInt(this.blogCount);
        parcel.writeInt(this.shuoshuoCount);
        parcel.writeInt(this.messageCount);
    }

    private void C0(Parcel parcel) {
        parcel.writeInt(this.isShowFamily ? 1 : 0);
        parcel.writeString(this.familyUrl);
        parcel.writeInt(this.showFamilyRedDot ? 1 : 0);
        parcel.writeString(this.familyDescription);
        parcel.writeString(this.familyTraceInfo);
        parcel.writeString(this.familyAvatarUrl);
        parcel.writeLong(this.familyAvatarUin);
    }

    private void D0(Parcel parcel) {
        parcel.writeInt(this.hasFooterBanner ? 1 : 0);
        parcel.writeString(this.footerBannerBackgroundUrl);
        parcel.writeString(this.footerBannerJumpUrl);
        parcel.writeString(this.footerBannerTraceInfo);
    }

    private void E0(Parcel parcel) {
        parcel.writeInt(this.friendRequestCount);
        parcel.writeInt(this.friendRequestNewCount);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.friendRequestList);
    }

    private String F() {
        return encryptUin(this.uin);
    }

    private void F0(Parcel parcel) {
        parcel.writeInt(this.friendship);
        parcel.writeString(this.friendshipJumpUrl);
    }

    private void I0(Parcel parcel) {
        parcel.writeString(this.jumpUrlParamsForLoveZone);
    }

    private void J0(Parcel parcel) {
        parcel.writeInt(this.loverSpaceCount);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.loverSpaceList);
    }

    private void K0(Parcel parcel) {
        parcel.writeInt(this.relationShip);
        parcel.writeInt(this.askForFriend ? 1 : 0);
        parcel.writeString(this.askForFriendMsg);
        parcel.writeInt(this.isSpecialCare ? 1 : 0);
        parcel.writeInt(this.isBlocked ? 1 : 0);
        parcel.writeInt(this.isExcluded ? 1 : 0);
        parcel.writeInt(this.isDisplayNameSet ? 1 : 0);
        parcel.writeInt(this.isBothFriend ? 1 : 0);
        parcel.writeList(this.questionList);
        parcel.writeBundle(this.promptMsg);
        parcel.writeInt(this.isReverseBlack ? 1 : 0);
        parcel.writeInt(this.isRecipientYellowBanner ? 1 : 0);
        parcel.writeString(this.relationShipMsg);
        parcel.writeInt(this.isFriend ? 1 : 0);
        parcel.writeInt(this.isShowWeishi ? 1 : 0);
    }

    private void L0(Parcel parcel) {
        parcel.writeInt(this.isOpenMsgBoard ? 1 : 0);
    }

    private Pair<Integer, ArrayList<RedInfo>> M(Map<Integer, s_red_comm> map, int i3) {
        ArrayList arrayList = new ArrayList();
        s_red_comm G = G(map, i3);
        int i16 = 0;
        if (G != null) {
            ArrayList<Integer> arrayList2 = G.subid;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                int i17 = 0;
                while (i16 < G.subid.size()) {
                    int intValue = G.subid.get(i16).intValue();
                    s_red_comm G2 = G(map, intValue);
                    if (G2 != null) {
                        i17 = (int) (i17 + G2.undealnum);
                        C(G2.redinfo, arrayList, intValue);
                    }
                    i16++;
                }
                i16 = i17;
            } else {
                i16 = (int) G.undealnum;
                C(G.redinfo, arrayList, i3);
            }
        }
        return new Pair<>(Integer.valueOf(i16), arrayList);
    }

    private void M0(Parcel parcel) {
        parcel.writeInt(this.greenDiamondFlag);
        parcel.writeInt(this.musicCanPlay ? 1 : 0);
        parcel.writeInt(this.allMusicNums);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.allMusicList);
        parcel.writeByte(this.wifiAutoPlayFlag);
        parcel.writeByte(this.playMode);
        parcel.writeInt(this.bgVoiceType);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.allFmList);
        parcel.writeByte(this.loopPlaybackType);
        parcel.writeList(this.allFmBroadCastList);
    }

    private void N(Parcel parcel) {
        this.albumRedCount = parcel.readInt();
    }

    private void O0(Parcel parcel) {
        parcel.writeLong(this.uin);
        parcel.writeString(this.name);
        parcel.writeString(this.nickName);
        parcel.writeString(this.qzoneName);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.age);
        parcel.writeString(this.astro);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeInt(this.isVip ? 1 : 0);
        parcel.writeInt(this.vipLevel);
        parcel.writeInt(this.vipType);
        parcel.writeInt(this.isAnnualVip);
        parcel.writeInt(this.isLoverZoneUser ? 1 : 0);
        parcel.writeInt(this.starVipStatus);
        parcel.writeInt(this.starVipLevel);
        parcel.writeInt(this.isStarAnnualVip ? 1 : 0);
        parcel.writeInt(this.isHighStarVip ? 1 : 0);
        parcel.writeInt(this.comVipType);
        parcel.writeInt(this.comViplevel);
        parcel.writeInt(this.isComAnnualVip ? 1 : 0);
        parcel.writeInt(this.isComAnnualVipEver ? 1 : 0);
        parcel.writeString(this.personalizedYellowVipUrl);
        parcel.writeString(this.vipurl);
        parcel.writeInt(this.customType);
        parcel.writeString(this.hostCustomIconUrl);
        parcel.writeString(this.guestCustomIconUrl);
        parcel.writeInt(this.brandFlag);
        parcel.writeInt(this.isCustomDiamondUser ? 1 : 0);
        parcel.writeString(this.customDiamondUrl);
    }

    private void P0(Parcel parcel) {
        parcel.writeString(this.jumpUrlForClickStrangerCover);
    }

    private void Q0(Parcel parcel) {
        parcel.writeInt(this.visitorCount);
        parcel.writeInt(this.visitorNewCount);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.visitorList);
        parcel.writeInt(this.refuseVisitorCount);
    }

    private void V(Parcel parcel) {
        this.appMessageCount = parcel.readInt();
    }

    private void Z(Parcel parcel) {
        this.birthdayCount = parcel.readInt();
        this.birthdayList = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void a0(Parcel parcel) {
        this.blogRedCount = parcel.readInt();
    }

    private void b0(Parcel parcel) {
        this.isCampusUser = parcel.readInt();
        this.unreadMood = parcel.readInt();
        this.unreadMessage = parcel.readInt();
    }

    private void c0(Parcel parcel) {
        this.isCertification = parcel.readInt() != 0;
        this.isFollowed = parcel.readInt() != 0;
        this.isSpecialFollowed = parcel.readInt() != 0;
        this.isSpecialFollowedPush = parcel.readInt() != 0;
        this.fansCount = parcel.readLong();
        this.fansExpr = parcel.readString();
        this.followCount = parcel.readLong();
        this.needShowSummaryInfo = parcel.readInt() != 0;
        this.isOpenFollow = parcel.readLong() != 0;
        this.isHostFollowGrayUsr = parcel.readLong() != 0;
        this.isVisitorFollowGrayUsr = parcel.readLong() != 0;
    }

    private void d0(Parcel parcel) {
        this.entranceItems = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void e0(Parcel parcel) {
        this.photoCount = parcel.readInt();
        this.blogCount = parcel.readInt();
        this.shuoshuoCount = parcel.readInt();
        this.messageCount = parcel.readInt();
    }

    public static String encryptUin(long j3) {
        return SecurityUtil.c(String.valueOf(j3));
    }

    private void f0(Parcel parcel) {
        this.isShowFamily = parcel.readInt() != 0;
        this.familyUrl = parcel.readString();
        this.showFamilyRedDot = parcel.readInt() != 0;
        this.familyDescription = parcel.readString();
        this.familyTraceInfo = parcel.readString();
        this.familyAvatarUrl = parcel.readString();
        this.familyAvatarUin = parcel.readLong();
    }

    private void g0(Parcel parcel) {
        this.hasFooterBanner = parcel.readInt() != 0;
        this.footerBannerBackgroundUrl = parcel.readString();
        this.footerBannerJumpUrl = parcel.readString();
        this.footerBannerTraceInfo = parcel.readString();
    }

    private void h0(Parcel parcel) {
        this.friendRequestCount = parcel.readInt();
        this.friendRequestNewCount = parcel.readInt();
        this.friendRequestList = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void i0(Parcel parcel) {
        this.friendship = parcel.readInt();
        this.friendshipJumpUrl = parcel.readString();
    }

    private void j0(Parcel parcel) {
        this.funnySpaceModels = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void k0(Parcel parcel) {
        this.limitPageInfoCardItems = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void l0(Parcel parcel) {
        this.jumpUrlParamsForLoveZone = parcel.readString();
    }

    private void m0(Parcel parcel) {
        this.loverSpaceCount = parcel.readInt();
        this.loverSpaceList = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void n0(Parcel parcel) {
        this.relationShip = parcel.readInt();
        this.askForFriend = parcel.readInt() != 0;
        this.askForFriendMsg = parcel.readString();
        this.isSpecialCare = parcel.readInt() != 0;
        this.isBlocked = parcel.readInt() != 0;
        this.isExcluded = parcel.readInt() != 0;
        this.isDisplayNameSet = parcel.readInt() != 0;
        this.isBothFriend = parcel.readInt() != 0;
        parcel.readList(this.questionList, String.class.getClassLoader());
        this.promptMsg = parcel.readBundle();
        this.isReverseBlack = parcel.readInt() != 0;
        this.isRecipientYellowBanner = parcel.readInt() != 0;
        this.relationShipMsg = parcel.readString();
        this.isFriend = parcel.readInt() != 0;
        this.isShowWeishi = parcel.readInt() != 0;
    }

    private void o0(Parcel parcel) {
        this.isOpenMsgBoard = parcel.readInt() != 0;
    }

    private void p0(Parcel parcel) {
        this.greenDiamondFlag = (byte) parcel.readInt();
        this.musicCanPlay = parcel.readInt() != 0;
        this.allMusicNums = parcel.readInt();
        this.allMusicList = ParcelableWrapper.createArrayListFromParcel(parcel);
        this.wifiAutoPlayFlag = parcel.readByte();
        this.playMode = parcel.readByte();
        this.bgVoiceType = parcel.readInt();
        this.allFmList = ParcelableWrapper.createArrayListFromParcel(parcel);
        this.loopPlaybackType = parcel.readByte();
        this.allFmBroadCastList = parcel.readArrayList(BroadcastMusicInfo.class.getClassLoader());
    }

    private void q0(Parcel parcel) {
        this.photoList = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    private void r0(Parcel parcel) {
        this.uin = parcel.readLong();
        this.name = parcel.readString();
        this.nickName = parcel.readString();
        this.qzoneName = parcel.readString();
        this.gender = parcel.readInt();
        this.age = parcel.readInt();
        this.astro = parcel.readString();
        this.country = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.isVip = parcel.readInt() != 0;
        this.vipLevel = parcel.readInt();
        this.vipType = parcel.readInt();
        this.isAnnualVip = parcel.readInt();
        this.isLoverZoneUser = parcel.readInt() != 0;
        this.starVipStatus = parcel.readInt();
        this.starVipLevel = parcel.readInt();
        this.isStarAnnualVip = parcel.readInt() != 0;
        this.isHighStarVip = parcel.readInt() != 0;
        this.comVipType = parcel.readInt();
        this.comViplevel = parcel.readInt();
        this.isComAnnualVip = parcel.readInt() != 0;
        this.isComAnnualVipEver = parcel.readInt() != 0;
        this.personalizedYellowVipUrl = parcel.readString();
        this.vipurl = parcel.readString();
        this.customType = parcel.readInt();
        this.hostCustomIconUrl = parcel.readString();
        this.guestCustomIconUrl = parcel.readString();
        this.brandFlag = parcel.readInt();
        this.isCustomDiamondUser = parcel.readInt() != 0;
        this.customDiamondUrl = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        n0(parcel);
        r0(parcel);
        e0(parcel);
        t0(parcel);
        Z(parcel);
        h0(parcel);
        V(parcel);
        c0(parcel);
        q0(parcel);
        i0(parcel);
        p0(parcel);
        b0(parcel);
        m0(parcel);
        o0(parcel);
        N(parcel);
        g0(parcel);
        k0(parcel);
        f0(parcel);
        d0(parcel);
        j0(parcel);
        a0(parcel);
        s0(parcel);
        l0(parcel);
    }

    private void s0(Parcel parcel) {
        this.jumpUrlForClickStrangerCover = parcel.readString();
    }

    private void t0(Parcel parcel) {
        this.visitorCount = parcel.readInt();
        this.visitorNewCount = parcel.readInt();
        this.visitorList = ParcelableWrapper.createArrayListFromParcel(parcel);
        this.refuseVisitorCount = parcel.readInt();
    }

    private void u0(Parcel parcel) {
        parcel.writeInt(this.albumRedCount);
    }

    private void v0(Parcel parcel) {
        parcel.writeInt(this.appMessageCount);
    }

    private void w(mobile_main_page_rsp mobile_main_page_rspVar) {
        x(mobile_main_page_rspVar.redinfo);
    }

    private void w0(Parcel parcel) {
        parcel.writeInt(this.birthdayCount);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.birthdayList);
    }

    private void writeToParcel(Parcel parcel) {
        K0(parcel);
        O0(parcel);
        B0(parcel);
        Q0(parcel);
        w0(parcel);
        E0(parcel);
        v0(parcel);
        z0(parcel);
        N0(parcel);
        F0(parcel);
        M0(parcel);
        y0(parcel);
        J0(parcel);
        L0(parcel);
        u0(parcel);
        D0(parcel);
        H0(parcel);
        C0(parcel);
        A0(parcel);
        G0(parcel);
        x0(parcel);
        P0(parcel);
        I0(parcel);
    }

    private void x0(Parcel parcel) {
        parcel.writeInt(this.blogRedCount);
    }

    private void y0(Parcel parcel) {
        parcel.writeInt(this.isCampusUser);
        parcel.writeInt(this.unreadMood);
        parcel.writeInt(this.unreadMessage);
    }

    private void z0(Parcel parcel) {
        parcel.writeInt(this.isCertification ? 1 : 0);
        parcel.writeInt(this.isFollowed ? 1 : 0);
        parcel.writeInt(this.isSpecialFollowed ? 1 : 0);
        parcel.writeInt(this.isSpecialFollowedPush ? 1 : 0);
        parcel.writeLong(this.fansCount);
        parcel.writeString(this.fansExpr);
        parcel.writeLong(this.followCount);
        parcel.writeInt(this.needShowSummaryInfo ? 1 : 0);
        parcel.writeLong(this.isOpenFollow ? 1L : 0L);
        parcel.writeLong(this.isHostFollowGrayUsr ? 1L : 0L);
        parcel.writeLong(this.isVisitorFollowGrayUsr ? 1L : 0L);
    }

    public String getGenderText() {
        if (this.gender == 1) {
            return l.a(R.string.skz);
        }
        return l.a(R.string.wbp);
    }

    public boolean isCommonSpaceUser() {
        return (this.brandFlag & 0) != 0;
    }

    public boolean isFamousUser() {
        return isOld52SpaceUser() || isVideo57SpaceUser() || isSchoolSpaceUser() || isStarSpaceUser() || isFollow48SpaceUser() || this.isCertification;
    }

    public boolean isFollow48SpaceUser() {
        return (this.brandFlag & 16) != 0;
    }

    public boolean isLimitRelationship() {
        if (!y6.b.f(this.uin)) {
            return false;
        }
        int i3 = this.relationShip;
        if (i3 == 0) {
            return true;
        }
        switch (i3) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    public boolean isOld52SpaceUser() {
        return (this.brandFlag & 1) != 0;
    }

    public boolean isSchoolSpaceUser() {
        return (this.brandFlag & 4) != 0;
    }

    public boolean isStarSpaceUser() {
        return (this.brandFlag & 8) != 0;
    }

    public boolean isVideo57SpaceUser() {
        return (this.brandFlag & 2) != 0;
    }

    public boolean needShowHomePanel() {
        int i3 = this.userType;
        return i3 == 0 || i3 == 1;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("data", marshall);
        contentValues.put("uin", F());
    }

    private void A0(Parcel parcel) {
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.entranceItems);
    }

    private void D(List<s_user> list, List<User> list2) {
        E(list, list2, -1);
    }

    private void G0(Parcel parcel) {
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.funnySpaceModels);
    }

    private void H0(Parcel parcel) {
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.limitPageInfoCardItems);
    }

    private void N0(Parcel parcel) {
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.photoList);
    }

    private void x(Map<Integer, s_red_comm> map) {
        RedInfo redInfo;
        RedInfo redInfo2;
        Pair<Integer, ArrayList<RedInfo>> M = M(map, 2);
        this.birthdayCount = ((Integer) M.first).intValue();
        this.birthdayList = (ArrayList) M.second;
        this.yellowDiamondCount = ((Integer) M(map, 22).first).intValue();
        Pair<Integer, ArrayList<RedInfo>> M2 = M(map, 25);
        this.loverSpaceCount = ((Integer) M2.first).intValue();
        this.loverSpaceList = (ArrayList) M2.second;
        this.albumRedCount = ((Integer) M(map, 40).first).intValue();
        this.blogRedCount = ((Integer) M(map, 47).first).intValue();
        Pair<Integer, ArrayList<RedInfo>> M3 = M(map, 44);
        this.showFamilyRedDot = ((Integer) M3.first).intValue() > 0;
        ArrayList arrayList = (ArrayList) M3.second;
        if (arrayList != null && !arrayList.isEmpty() && (redInfo2 = (RedInfo) arrayList.get(0)) != null) {
            this.familyAvatarUrl = redInfo2.logo;
            this.familyAvatarUin = redInfo2.uin;
        }
        Pair<Integer, ArrayList<RedInfo>> M4 = M(map, 45);
        Object obj = M4.second;
        if (obj == null || ((ArrayList) obj).isEmpty() || (redInfo = (RedInfo) ((ArrayList) M4.second).get(0)) == null) {
            return;
        }
        this.myFriendsAvatarText = redInfo.desc;
        this.myFriendsAvartarUin = redInfo.uin;
    }

    private void o(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_limit_page_card s_limit_page_cardVar;
        if (mobile_main_page_rspVar == null || (s_limit_page_cardVar = mobile_main_page_rspVar.limit_page_card) == null || s_limit_page_cardVar.lst_data == null) {
            return;
        }
        this.limitPageInfoCardItems = new ArrayList<>();
        Iterator<s_limit_page_card_item> it = mobile_main_page_rspVar.limit_page_card.lst_data.iterator();
        while (it.hasNext()) {
            s_limit_page_card_item next = it.next();
            if (next != null) {
                LimitPageInfoCardItem limitPageInfoCardItem = new LimitPageInfoCardItem();
                limitPageInfoCardItem.iconUrl = next.img;
                limitPageInfoCardItem.text = next.text;
                this.limitPageInfoCardItems.add(limitPageInfoCardItem);
            }
        }
    }

    private void z(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_urge_publish_info s_urge_publish_infoVar;
        if (mobile_main_page_rspVar == null || (s_urge_publish_infoVar = mobile_main_page_rspVar.urge_publish) == null) {
            return;
        }
        this.urgePublishInfo = QZoneUrgePublishInfo.INSTANCE.a(s_urge_publish_infoVar);
    }

    private void A(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_visit s_visitVar;
        if (mobile_main_page_rspVar == null || (s_visitVar = mobile_main_page_rspVar.visit) == null) {
            return;
        }
        this.visitorCount = s_visitVar.totalnum;
        int i3 = s_visitVar.nvnum;
        this.visitorNewCount = i3;
        s_visit s_visitVar2 = mobile_main_page_rspVar.visit_no_right;
        if (s_visitVar2 == null) {
            return;
        }
        E(s_visitVar.datalist, this.visitorList, i3);
        this.refuseVisitorCount = s_visitVar2.totalnum;
    }

    private void B(mobile_main_page_rsp mobile_main_page_rspVar) {
        byte[] bArr;
        StrangerSkin strangerSkin;
        StrangerSkin strangerSkin2;
        if (mobile_main_page_rspVar == null) {
            return;
        }
        try {
            s_profile s_profileVar = mobile_main_page_rspVar.profile;
            if (s_profileVar == null || (bArr = s_profileVar.QzmallProfileDecoGetRsp) == null) {
                return;
            }
            MainpageQzmallDeco mainpageQzmallDeco = (MainpageQzmallDeco) t5.b.b(MainpageQzmallDeco.class, bArr);
            if (mainpageQzmallDeco != null && (strangerSkin2 = mainpageQzmallDeco.stStrangerSkin) != null && strangerSkin2.iItemId != -1) {
                d dVar = new d();
                this.strangerDecorate = dVar;
                dVar.a(mainpageQzmallDeco.stStrangerSkin.iItemId);
                this.strangerDecorate.b(mainpageQzmallDeco.stStrangerSkin.strImageUrl);
                this.strangerDecorate.c(mainpageQzmallDeco.stStrangerSkin.strTextColor1);
                this.strangerDecorate.d(mainpageQzmallDeco.stStrangerSkin.strTextColor2);
            }
            if (mainpageQzmallDeco == null || (strangerSkin = mainpageQzmallDeco.stStrangerSkin) == null || TextUtils.isEmpty(strangerSkin.strJumpUrl)) {
                return;
            }
            this.jumpUrlForClickStrangerCover = mainpageQzmallDeco.stStrangerSkin.strJumpUrl;
        } catch (Exception e16) {
            QZLog.e("BusineessUserinfo decodeFunnySpaceModels", e16.getMessage());
        }
    }

    private void e(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_appinfo s_appinfoVar;
        if (mobile_main_page_rspVar == null || (s_appinfoVar = mobile_main_page_rspVar.appinfo) == null) {
            return;
        }
        this.appMessageCount = s_appinfoVar.infonum;
    }

    private void f(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_campus_qz s_campus_qzVar;
        if (mobile_main_page_rspVar == null || (s_campus_qzVar = mobile_main_page_rspVar.campus_qz) == null) {
            return;
        }
        this.isCampusUser = s_campus_qzVar.is_campus_qz_bar;
        this.unreadMood = s_campus_qzVar.num_feeds;
        this.unreadMessage = s_campus_qzVar.num_msg;
    }

    private void g(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_count s_countVar;
        if (mobile_main_page_rspVar == null || (s_countVar = mobile_main_page_rspVar.count) == null) {
            return;
        }
        this.photoCount = s_countVar.pic_allnum;
        this.blogCount = s_countVar.blog_allnum;
        this.shuoshuoCount = s_countVar.shuoshuo_allnum;
        this.messageCount = s_countVar.message_allnum;
        s_profile s_profileVar = mobile_main_page_rspVar.profile;
        this.fansCount = s_profileVar.fans_num;
        this.fansExpr = s_profileVar.fans_num_express;
        this.followCount = s_profileVar.follow_num;
        this.needShowSummaryInfo = s_profileVar.show_menu_panel;
    }

    private void j(mobile_main_page_rsp mobile_main_page_rspVar) {
        Map<Integer, s_mainPageTabItem> map;
        Pair<Integer, ArrayList<RedInfo>> M;
        Object obj;
        RedInfo redInfo;
        if (mobile_main_page_rspVar == null || (map = mobile_main_page_rspVar.map_entrys) == null || map.isEmpty()) {
            return;
        }
        ArrayList<EntranceItem> arrayList = this.entranceItems;
        if (arrayList == null) {
            this.entranceItems = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        for (Integer num : mobile_main_page_rspVar.map_entrys.keySet()) {
            s_mainPageTabItem s_mainpagetabitem = mobile_main_page_rspVar.map_entrys.get(num);
            if (s_mainpagetabitem != null) {
                EntranceItem entranceItem = new EntranceItem();
                entranceItem.redId = num.intValue();
                entranceItem.content = s_mainpagetabitem.content;
                entranceItem.iconUrl = s_mainpagetabitem.icon;
                entranceItem.jumpUrl = s_mainpagetabitem.jumpUrl;
                Map<Integer, s_red_comm> map2 = mobile_main_page_rspVar.redinfo;
                if (map2 != null && (obj = (M = M(map2, num.intValue())).second) != null && !((ArrayList) obj).isEmpty() && (redInfo = (RedInfo) ((ArrayList) M.second).get(0)) != null) {
                    entranceItem.avatarText = redInfo.summary;
                    entranceItem.avatarUin = redInfo.uin;
                }
                this.entranceItems.add(entranceItem);
            }
        }
        Collections.sort(this.entranceItems, new C11531a());
    }

    private void k(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_gamebar_pk_banner s_gamebar_pk_bannerVar;
        if (mobile_main_page_rspVar == null || (s_gamebar_pk_bannerVar = mobile_main_page_rspVar.pk_banner) == null) {
            return;
        }
        this.hasFooterBanner = s_gamebar_pk_bannerVar.banner_state == 1;
        this.footerBannerBackgroundUrl = s_gamebar_pk_bannerVar.pic_url;
        this.footerBannerJumpUrl = s_gamebar_pk_bannerVar.jump_url;
        this.footerBannerTraceInfo = s_gamebar_pk_bannerVar.trace_info;
    }

    private void l(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_friendreq s_friendreqVar;
        if (mobile_main_page_rspVar == null || (s_friendreqVar = mobile_main_page_rspVar.friendreq) == null) {
            return;
        }
        this.friendRequestCount = s_friendreqVar.allnum;
        ArrayList<s_user> arrayList = s_friendreqVar.datalistnew;
        this.friendRequestNewCount = arrayList == null ? 0 : arrayList.size();
        D(s_friendreqVar.datalistnew, this.friendRequestList);
    }

    private void m(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_friend_ship s_friend_shipVar;
        if (mobile_main_page_rspVar == null || (s_friend_shipVar = mobile_main_page_rspVar.friend_ship) == null) {
            return;
        }
        this.friendship = s_friend_shipVar.intimacyScore;
        this.friendshipJumpUrl = s_friend_shipVar.url;
    }

    private void p(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_main_page s_main_pageVar;
        if (mobile_main_page_rspVar == null || (s_main_pageVar = mobile_main_page_rspVar.mainpage) == null) {
            return;
        }
        this.relationShip = s_main_pageVar.relation;
        this.relationShipMsg = s_main_pageVar.f25007msg;
        this.askForFriend = s_main_pageVar.is_askfor_friend != 0;
        this.askForFriendMsg = s_main_pageVar.info_askfor_friend;
        this.isSpecialCare = s_main_pageVar.is_special != 0;
        this.isFriend = s_main_pageVar.is_friend != 0;
        s_profile s_profileVar = mobile_main_page_rspVar.profile;
        if (s_profileVar != null) {
            this.isCertification = s_profileVar.isFamousQzone;
        }
        this.isFollowed = s_main_pageVar.is_concerned;
        long j3 = s_main_pageVar.follow_flag;
        this.isSpecialFollowed = (j3 & 1) == 1;
        this.isSpecialFollowedPush = (j3 & 2) == 2;
        this.isOpenFollow = s_main_pageVar.is_open_follow != 0;
        s_sq_mainpage_switch s_sq_mainpage_switchVar = mobile_main_page_rspVar.sq_mainpage_switch;
        if (s_sq_mainpage_switchVar != null) {
            this.isShowWeishi = s_sq_mainpage_switchVar.is_show_weishi;
        }
        this.isHostFollowGrayUsr = s_main_pageVar.is_host_gray_follow_usr != 0;
        this.isVisitorFollowGrayUsr = s_main_pageVar.is_visitor_gray_follow_usr != 0;
        this.isBlocked = s_main_pageVar.is_black != 0;
        this.isExcluded = s_main_pageVar.is_uncare != 0;
        this.isDisplayNameSet = s_main_pageVar.is_realname != 0;
        this.isBothFriend = s_main_pageVar.is_both_friend != 0;
        Map<Integer, String> map = s_main_pageVar.prompt_msg;
        this.rawPromptMsg = map;
        this.isReverseBlack = s_main_pageVar.is_reverse_black != 0;
        this.isRecipientYellowBanner = s_main_pageVar.is_recipient_yellow_banner != 0;
        this.is_in_visitor_notify_list = s_main_pageVar.is_in_visitor_notify_list;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            this.promptMsg.putString(String.valueOf(entry.getKey()), entry.getValue());
        }
        s_question s_questionVar = s_main_pageVar.question;
        if (s_questionVar != null) {
            String str = s_questionVar.qustion1;
            if (str != null && !str.equals("")) {
                this.questionList.add(str);
            }
            String str2 = s_questionVar.qustion2;
            if (str2 != null && !str2.equals("")) {
                this.questionList.add(str2);
            }
            String str3 = s_questionVar.qustion3;
            if (str3 != null && !str3.equals("")) {
                this.questionList.add(str3);
            }
        }
        this.isShowFamily = s_main_pageVar.is_family_open;
        this.familyUrl = s_main_pageVar.family_url;
        this.familyDescription = s_main_pageVar.family_des;
        this.familyTraceInfo = s_main_pageVar.family_url_traceinfo;
        s_mainPageTabItem s_mainpagetabitem = mobile_main_page_rspVar.myFriendEntryItem;
        boolean z16 = (s_mainpagetabitem == null || TextUtils.isEmpty(s_mainpagetabitem.icon) || TextUtils.isEmpty(mobile_main_page_rspVar.myFriendEntryItem.content) || TextUtils.isEmpty(mobile_main_page_rspVar.myFriendEntryItem.jumpUrl)) ? false : true;
        this.isShowMyFriends = z16;
        if (z16) {
            s_mainPageTabItem s_mainpagetabitem2 = mobile_main_page_rspVar.myFriendEntryItem;
            this.myFriendsIconUrl = s_mainpagetabitem2.icon;
            this.myFriendsTitle = s_mainpagetabitem2.content;
            this.myFriendsJumpUrl = s_mainpagetabitem2.jumpUrl;
        }
    }

    private void q(mobile_main_page_rsp mobile_main_page_rspVar) {
        if (mobile_main_page_rspVar == null) {
            return;
        }
        this.isOpenMsgBoard = mobile_main_page_rspVar.open_msg_board;
    }

    private void r(mobile_main_page_rsp mobile_main_page_rspVar) {
        if (mobile_main_page_rspVar == null) {
            return;
        }
        this.wifiAutoPlayFlag = mobile_main_page_rspVar.wifi_auto_play;
        this.playMode = mobile_main_page_rspVar.play_mode_flag;
        this.bgVoiceType = 0;
        this.loopPlaybackType = mobile_main_page_rspVar.loop_playback_flag;
        QZLog.i("Music", "uin=" + this.uin + ",bgVoiceType=" + this.bgVoiceType + ",wifiAutoPlayFlag=" + ((int) this.wifiAutoPlayFlag) + ",playMode=" + ((int) this.playMode) + ",loopPlaybackType=" + ((int) this.loopPlaybackType));
        byte[] bArr = mobile_main_page_rspVar.bgvoice_buf;
        if (bArr != null && bArr.length > 0) {
            decodeBGVoiceData(this, (BGVoice) t5.b.b(BGVoice.class, bArr));
        } else {
            QZLog.i("Music", "\u80cc\u666f\u97f3\u4e50\u6570\u636e bgvoice_buf empty");
        }
    }

    private void s(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_tab_list s_tab_listVar;
        if (mobile_main_page_rspVar == null || (s_tab_listVar = mobile_main_page_rspVar.tab_lst_mq) == null) {
            return;
        }
        this.mPanelShowList = com.qzone.homepage.ui.component.newpanel.c.c(s_tab_listVar.lst_show);
        this.mPanelHideList = com.qzone.homepage.ui.component.newpanel.c.c(s_tab_listVar.lst_hide);
        Map<Integer, s_red_comm> map = mobile_main_page_rspVar.redinfo;
        if (map == null) {
            return;
        }
        this.mPanelShowList = com.qzone.homepage.ui.component.newpanel.c.e(this.mPanelShowList, map);
        this.mPanelHideList = com.qzone.homepage.ui.component.newpanel.c.e(this.mPanelHideList, mobile_main_page_rspVar.redinfo);
        if (mobile_main_page_rspVar.redinfo.containsKey(48)) {
            this.moreNewCount = 1;
        }
    }

    private void t(mobile_main_page_rsp mobile_main_page_rspVar) {
        ArrayList<byte[]> arrayList;
        if (mobile_main_page_rspVar == null || (arrayList = mobile_main_page_rspVar.photos_buf) == null) {
            return;
        }
        Iterator<byte[]> it = arrayList.iterator();
        while (it.hasNext()) {
            u(it.next(), this.photoList);
        }
    }

    private void v(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_profile s_profileVar;
        if (mobile_main_page_rspVar == null || (s_profileVar = mobile_main_page_rspVar.profile) == null) {
            return;
        }
        this.uin = s_profileVar.uin;
        this.name = s_profileVar.nickname;
        this.nickName = s_profileVar.nick;
        this.qzoneName = s_profileVar.qzonename;
        this.gender = s_profileVar.gender == 1 ? 1 : 0;
        this.age = s_profileVar.age;
        this.astro = s_profileVar.astro;
        this.country = s_profileVar.country;
        this.province = s_profileVar.province;
        this.city = s_profileVar.city;
        this.isVip = s_profileVar.vip != 0;
        this.vipLevel = s_profileVar.viplevel;
        this.vipType = s_profileVar.viptype;
        this.vipLeftDays = s_profileVar.strvipoverday;
        this.isAnnualVip = s_profileVar.isAnnualVip;
        this.spaceDesc = s_profileVar.space_desc;
        this.isLoverZoneUser = s_profileVar.is_sweet_user;
        star_info star_infoVar = s_profileVar.stuStarInfo;
        if (star_infoVar != null) {
            this.starVipStatus = star_infoVar.iStarStatus;
            this.starVipLevel = star_infoVar.iStarLevel;
            this.isStarAnnualVip = star_infoVar.isAnnualVip != 0;
            this.isHighStarVip = star_infoVar.isHighStarVip != 0;
        }
        combine_diamond_info combine_diamond_infoVar = s_profileVar.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            this.comVipType = combine_diamond_infoVar.iShowType;
            this.comViplevel = combine_diamond_infoVar.iVipLevel;
            this.isComAnnualVip = combine_diamond_infoVar.isAnnualVip != 0;
            this.isComAnnualVipEver = combine_diamond_infoVar.isAnnualVipEver != 0;
        }
        this.vipurl = s_profileVar.vipurl;
        this.brandFlag = s_profileVar.brand_flag;
        this.share_bg_url = mobile_main_page_rspVar.share_bg_url;
        this.userType = s_profileVar.user_type;
    }

    private void y(mobile_main_page_rsp mobile_main_page_rspVar) {
        s_tab_list s_tab_listVar;
        if (mobile_main_page_rspVar == null || (s_tab_listVar = mobile_main_page_rspVar.tab_top_lst) == null) {
            return;
        }
        ArrayList<HomePanelItem> c16 = com.qzone.homepage.ui.component.newpanel.c.c(s_tab_listVar.lst_show);
        this.mTopPanelShowList = c16;
        Map<Integer, s_red_comm> map = mobile_main_page_rspVar.redinfo;
        if (map == null) {
            return;
        }
        this.mTopPanelShowList = com.qzone.homepage.ui.component.newpanel.c.e(c16, map);
    }

    private s_red_comm G(Map<Integer, s_red_comm> map, int i3) {
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i3));
    }

    public static a createFrom(mobile_main_page_rsp mobile_main_page_rspVar) {
        if (mobile_main_page_rspVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.p(mobile_main_page_rspVar);
        aVar.v(mobile_main_page_rspVar);
        aVar.g(mobile_main_page_rspVar);
        aVar.A(mobile_main_page_rspVar);
        aVar.w(mobile_main_page_rspVar);
        aVar.l(mobile_main_page_rspVar);
        aVar.e(mobile_main_page_rspVar);
        aVar.t(mobile_main_page_rspVar);
        aVar.m(mobile_main_page_rspVar);
        aVar.r(mobile_main_page_rspVar);
        aVar.f(mobile_main_page_rspVar);
        aVar.q(mobile_main_page_rspVar);
        aVar.k(mobile_main_page_rspVar);
        aVar.o(mobile_main_page_rspVar);
        aVar.j(mobile_main_page_rspVar);
        aVar.n(mobile_main_page_rspVar);
        aVar.B(mobile_main_page_rspVar);
        aVar.s(mobile_main_page_rspVar);
        aVar.y(mobile_main_page_rspVar);
        aVar.z(mobile_main_page_rspVar);
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c7, code lost:
    
        if (r6.funnySpaceModels.size() == 0) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:6:0x0004, B:8:0x0008, B:10:0x000c, B:12:0x0010, B:14:0x0014, B:16:0x001f, B:18:0x0023, B:27:0x0051, B:29:0x0063, B:31:0x0067, B:33:0x006d, B:35:0x0071, B:36:0x007c, B:37:0x0082, B:39:0x0088, B:42:0x0091, B:49:0x00c1, B:52:0x0079, B:53:0x0097, B:55:0x009b, B:56:0x00a6, B:57:0x00ac, B:59:0x00b2, B:62:0x00bb, B:69:0x00a3, B:73:0x0044, B:20:0x0031, B:22:0x0035, B:23:0x003c), top: B:5:0x0004, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n(mobile_main_page_rsp mobile_main_page_rspVar) {
        FunnySpace funnySpace;
        byte[] bArr;
        FunnySpace funnySpace2;
        boolean z16;
        if (mobile_main_page_rspVar == null) {
            return;
        }
        boolean z17 = true;
        try {
            s_profile s_profileVar = mobile_main_page_rspVar.profile;
            if (s_profileVar != null && (bArr = s_profileVar.QzmallProfileDecoGetRsp) != null && (funnySpace2 = mobile_main_page_rspVar.StuFunnySpace) != null && funnySpace2.is_show) {
                MainpageQzmallDeco mainpageQzmallDeco = (MainpageQzmallDeco) t5.b.b(MainpageQzmallDeco.class, bArr);
                if (mainpageQzmallDeco != null && mainpageQzmallDeco.stCustomTrack != null) {
                    QzoneCustomTrackData customtrackreadFromJce = QzoneCustomTrackData.customtrackreadFromJce(LoginData.getInstance().getUin(), mainpageQzmallDeco.stCustomTrack);
                    try {
                        if (customtrackreadFromJce.iItemId != 0) {
                            com.qzone.personalize.business.b.n().w(customtrackreadFromJce);
                        }
                    } catch (Exception e16) {
                        QZLog.e("BusineessUserinfo  save erro", e16.getMessage());
                    }
                    if (customtrackreadFromJce.iItemId != -1) {
                        z16 = false;
                        if (!z16) {
                            QzoneCustomTrackData g16 = com.qzone.personalize.business.b.n().g(LoginData.getInstance().getUin());
                            if (g16 != null && g16.iItemId != -1) {
                                if (mobile_main_page_rspVar.StuFunnySpace.is_block) {
                                    ArrayList<FunnySpaceModel> arrayList = this.funnySpaceModels;
                                    if (arrayList == null) {
                                        this.funnySpaceModels = new ArrayList<>();
                                    } else {
                                        arrayList.clear();
                                    }
                                    Iterator<FunnySpaceModel> it = g16.blockModelList.iterator();
                                    while (it.hasNext()) {
                                        FunnySpaceModel next = it.next();
                                        if (next != null) {
                                            this.funnySpaceModels.add(next);
                                        }
                                    }
                                } else {
                                    ArrayList<FunnySpaceModel> arrayList2 = this.funnySpaceModels;
                                    if (arrayList2 == null) {
                                        this.funnySpaceModels = new ArrayList<>();
                                    } else {
                                        arrayList2.clear();
                                    }
                                    Iterator<FunnySpaceModel> it5 = g16.normalModelList.iterator();
                                    while (it5.hasNext()) {
                                        FunnySpaceModel next2 = it5.next();
                                        if (next2 != null) {
                                            this.funnySpaceModels.add(next2);
                                        }
                                    }
                                }
                            }
                        }
                        z17 = z16;
                    }
                }
                z16 = true;
                if (!z16) {
                }
                z17 = z16;
            }
        } catch (Exception e17) {
            QZLog.e("BusineessUserinfo decodeFunnySpaceModels", e17.getMessage());
        }
        if (z17 && (funnySpace = mobile_main_page_rspVar.StuFunnySpace) != null && funnySpace.Actions.size() > 0) {
            ArrayList<FunnySpaceModel> arrayList3 = this.funnySpaceModels;
            if (arrayList3 == null) {
                this.funnySpaceModels = new ArrayList<>();
            } else {
                arrayList3.clear();
            }
            Iterator<FunnySpaceAction> it6 = mobile_main_page_rspVar.StuFunnySpace.Actions.iterator();
            while (it6.hasNext()) {
                FunnySpaceAction next3 = it6.next();
                if (next3 != null) {
                    this.funnySpaceModels.add(FunnySpaceModel.create(next3));
                }
            }
        }
        FunnySpace funnySpace3 = mobile_main_page_rspVar.StuFunnySpace;
        if (funnySpace3 != null) {
            this.funnySpaceTotalCount = funnySpace3.TotalCount;
        }
    }

    public boolean isSameFriendShip(a aVar) {
        return aVar != null && TextUtils.equals(aVar.friendshipJumpUrl, this.friendshipJumpUrl) && aVar.friendship == this.friendship;
    }

    private void E(List<s_user> list, List<User> list2, int i3) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        if (i3 > 0) {
            size = Math.min(size, i3);
        }
        for (int i16 = 0; i16 < size; i16++) {
            s_user s_userVar = list.get(i16);
            if (s_userVar != null) {
                list2.add(new User(s_userVar.uin, s_userVar.nickname));
            }
        }
    }

    private void C(List<s_red_info> list, List<RedInfo> list2, int i3) {
        if (list == null || list2 == null) {
            return;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            list2.add(RedInfo.createFrom(list.get(i16)));
        }
    }

    private static void u(byte[] bArr, Collection<PictureItem> collection) {
        cell_pic cell_picVar;
        ArrayList<s_picdata> arrayList;
        s_picurl s_picurlVar;
        if (collection == null || bArr == null || (cell_picVar = (cell_pic) t5.b.b(cell_pic.class, bArr)) == null || (arrayList = cell_picVar.picdata) == null) {
            return;
        }
        Iterator<s_picdata> it = arrayList.iterator();
        while (it.hasNext()) {
            s_picdata next = it.next();
            if (next != null) {
                PictureItem pictureItem = new PictureItem();
                String str = cell_picVar.albumid;
                pictureItem.albumId = str;
                pictureItem.picname = next.picname;
                pictureItem.sloc = next.sloc;
                pictureItem.lloc = next.lloc;
                pictureItem.type = next.type;
                pictureItem.isLike = next.ismylike;
                pictureItem.likeCount = next.likecount;
                pictureItem.commentCount = next.commentcount;
                pictureItem.busi_param = next.busi_param;
                pictureItem.faceLists = FaceData.toFaceDataList(next.facelist, str, cell_picVar.uin);
                if (next.photourl != null) {
                    int[] iArr = f447257d;
                    PictureUrl[] pictureUrlArr = {pictureItem.currentUrl, pictureItem.bigUrl, pictureItem.originUrl};
                    for (int i3 = 0; i3 < iArr.length; i3++) {
                        PictureUrl pictureUrl = pictureUrlArr[i3];
                        if (pictureUrl != null && (s_picurlVar = next.photourl.get(Integer.valueOf(iArr[i3]))) != null) {
                            pictureUrl.url = s_picurlVar.url;
                            pictureUrl.width = s_picurlVar.width;
                            pictureUrl.height = s_picurlVar.height;
                        }
                    }
                }
                collection.add(pictureItem);
            }
        }
    }

    public static boolean decodeBGVoiceData(a aVar, BGVoice bGVoice) {
        ArrayList<BGMusicForQzone> arrayList;
        ArrayList<BroadcastForQzone> arrayList2;
        if (aVar == null || bGVoice == null) {
            return false;
        }
        int i3 = bGVoice.iTypeValue;
        aVar.bgVoiceType = i3;
        if (i3 == 0) {
            aVar.allMusicNums = 0;
            BGMusic bGMusic = bGVoice.bgMusicLists;
            if (bGMusic != null) {
                aVar.greenDiamondFlag = bGMusic.green_diamond_flag;
                aVar.musicCanPlay = bGMusic.music_can_play;
                aVar.allMusicNums = bGMusic.all_music_nums;
                if (bGMusic.all_music_list != null) {
                    aVar.allMusicList = new ArrayList<>();
                    Iterator<MusicInfo> it = bGVoice.bgMusicLists.all_music_list.iterator();
                    while (it.hasNext()) {
                        aVar.allMusicList.add(UserMusicInfo.createFrom(it.next()));
                    }
                }
            }
        } else if (i3 == 1) {
            aVar.musicCanPlay = true;
            aVar.allMusicNums = 0;
            BGFM bgfm = bGVoice.bgFmLists;
            if (bgfm != null && (arrayList = bgfm.stFmLists) != null) {
                aVar.allMusicNums = arrayList.size();
                aVar.allFmList = new ArrayList<>();
                Iterator<BGMusicForQzone> it5 = bGVoice.bgFmLists.stFmLists.iterator();
                while (it5.hasNext()) {
                    aVar.allFmList.add(UserMusicInfo.createFrom(it5.next()));
                }
            }
        } else if (i3 == 2) {
            aVar.musicCanPlay = true;
            aVar.allMusicNums = 0;
            BGFM bgfm2 = bGVoice.bgFmLists;
            if (bgfm2 != null && (arrayList2 = bgfm2.stFmBroadcast) != null) {
                aVar.allMusicNums = arrayList2.size();
                aVar.allFmBroadCastList = new ArrayList<>();
                Iterator<BroadcastForQzone> it6 = bGVoice.bgFmLists.stFmBroadcast.iterator();
                while (it6.hasNext()) {
                    aVar.allFmBroadCastList.add(BroadcastMusicInfo.a(it6.next()));
                }
            }
        } else {
            if (i3 != 3) {
                QZLog.i("Music", "\u80cc\u666f\u97f3\u4e50\u6570\u636e \u6b64\u7c7b\u578b\u503c\u4e0d\u8ba4\u8bc6 bgVoice.iTypeValue=" + bGVoice.iTypeValue);
                return false;
            }
            aVar.allMusicNums = 0;
            BGMusic bGMusic2 = bGVoice.bgMusicLists;
            if (bGMusic2 != null) {
                aVar.musicCanPlay = bGMusic2.music_can_play;
                aVar.allMusicNums = bGMusic2.all_music_nums;
                if (bGMusic2.all_music_list != null) {
                    aVar.allMusicList = new ArrayList<>();
                    Iterator<MusicInfo> it7 = bGVoice.bgMusicLists.all_music_list.iterator();
                    while (it7.hasNext()) {
                        UserMusicInfo createFrom = UserMusicInfo.createFrom(it7.next());
                        if (createFrom != null) {
                            if (!TextUtils.isEmpty(createFrom.qusicMid) && createFrom.qusicId == 0) {
                                createFrom.qusicId = ((IQzoneMusicHelper) QRoute.api(IQzoneMusicHelper.class)).getSongIDWithMid(createFrom.qusicMid);
                            }
                            if (createFrom.type == 0) {
                                createFrom.type = 11;
                            }
                            aVar.allMusicList.add(createFrom);
                        }
                    }
                }
            }
        }
        return true;
    }
}
