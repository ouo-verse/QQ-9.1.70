package tencent.gdt;

import com.qq.e.comm.constants.Constants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class indicator {
    public static final int DO_NOTHING = 0;
    public static final int HIDE_AD = 3;
    public static final int OPEN_JUMP_URL = 6;
    public static final int kAdInfo = 10;
    public static final int kDisplay = 13;
    public static final int kFeedsExposureCtrl = 14;
    public static final int kFeedsNoveltyCtrl = 15;
    public static final int kFeedsTimeIntervalCtrl = 20;
    public static final int kFillAd = 4;
    public static final int kFillDisplayResponse = 11;
    public static final int kForceNoAdForAntispamControl = 21;
    public static final int kForceNoAdForOverDailyQuota = 18;
    public static final int kForceNoAdForOverHourlyQuota = 19;
    public static final int kFrequenceLimitCtrl = 17;
    public static final int kGooglepayAdvertiserCtrl = 22;
    public static final int kIndex = 2;
    public static final int kMixerFilter = 9;
    public static final int kMixerNetworkFailed = 12;
    public static final int kNegativeFeedbackCtrl = 23;
    public static final int kOperationFlexbility = 1;
    public static final int kRerankingDocWash = 6;
    public static final int kRerankingInput = 7;
    public static final int kRerankingOutput = 8;
    public static final int kScoring = 3;
    public static final int kSkipRetrieval = 16;
    public static final int kSunfishNetworkFailed = 5;
    public static final int kUnknown = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AdCount extends MessageMicro<AdCount> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"index", "scoring", "fillad", "reranking_docwash", "reranking_input", "reranking_output", "mixer_filter", Constants.KEYS.AD_INFO, "mixer", "display"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, AdCount.class);
        public final PBUInt32Field index = PBField.initUInt32(0);
        public final PBUInt32Field scoring = PBField.initUInt32(0);
        public final PBUInt32Field fillad = PBField.initUInt32(0);
        public final PBUInt32Field reranking_docwash = PBField.initUInt32(0);
        public final PBUInt32Field reranking_input = PBField.initUInt32(0);
        public final PBUInt32Field reranking_output = PBField.initUInt32(0);
        public final PBUInt32Field mixer_filter = PBField.initUInt32(0);
        public final PBUInt32Field adinfo = PBField.initUInt32(0);
        public final PBUInt32Field mixer = PBField.initUInt32(0);
        public final PBUInt32Field display = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class NoAdIndicator extends MessageMicro<NoAdIndicator> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"partition_timestamp", "placement_id", "no_ad_reason", "ad_count"}, new Object[]{0, 0L, 0, null}, NoAdIndicator.class);
        public final PBUInt32Field partition_timestamp = PBField.initUInt32(0);
        public final PBUInt64Field placement_id = PBField.initUInt64(0);
        public final PBEnumField no_ad_reason = PBField.initEnum(0);
        public AdCount ad_count = new AdCount();
    }

    indicator() {
    }
}
