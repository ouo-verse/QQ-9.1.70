package tencent.gdt;

import com.google.gson.JsonObject;

/* compiled from: P */
/* loaded from: classes29.dex */
public class gdt_motive_hippy_data {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MotiveHippyData {
        public ExtendInfo extendInfo = new ExtendInfo();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ExtendInfo {
            public JsonObject adInfo;
            public JsonObject passThough;
            public String templateId;
            public BaseInfo baseInfo = new BaseInfo();
            public RewardAd rewardAd = new RewardAd();

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class BaseInfo {
                public int adHeight;
                public String adId;
                public int adWidth;
                public String effectExposureUrl;
                public String exp_id;
                public int exp_type;
                public JsonObject funcSwitch;
                public String originalExposureUrl;
                public String posId;
                public int safeAreaTop;
                public String sdkVersion;
                public String traceId;
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class RewardAd {
                public JsonObject passThoughRewardInfo;
                public Info info = new Info();
                public FeatureFlags featureFlags = new FeatureFlags();
                public Texts texts = new Texts();
                public Materials materials = new Materials();

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class FeatureFlags {
                    public int enableRewardWall;
                    public int hasCustomAlert;
                    public int hasExtraReward;
                    public int isMute;
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class Info {
                    public int appScore;
                    public int displayOrientation;
                    public int displayType;
                    public int hippyType;
                    public int initialAdListCount;
                    public int unlockTime;
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class Materials {
                    public AdVideo adVideo = new AdVideo();
                    public AdImage adImage = new AdImage();
                    public AdBrowser adBrowser = new AdBrowser();
                    public AdAvatar adAvatar = new AdAvatar();

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class AdAvatar {
                        public String url;
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class AdBrowser {
                        public int duration;
                        public String webUrl;
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class AdImage {
                        public String localUrl;
                        public String onlineUrl;
                        public int orientation;
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class AdVideo {
                        public int duration;
                        public String localUrl;
                        public String onlineUrl;
                        public int orientation;
                        public String posterUrl;
                        public int videoHeight;
                        public int videoWidth;
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class Texts {
                    public String actionButtonTitle;
                    public Dialog dialog = new Dialog();
                    public String durationShorterThanRewardTimeTips;
                    public String extraRewardInfo;
                    public String gradientRewardInfo;
                    public String rewardedTopTips;
                    public String subTitle;
                    public String title;
                    public String unRewardedTopTips;

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class Dialog {
                        public String cancel;
                        public String confirm;
                        public String dialogOneMore;
                        public String rewardedMessage;
                        public String unRewardedMessage;
                    }
                }
            }
        }
    }

    gdt_motive_hippy_data() {
    }
}
