package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ExtendFriendUserCategory$GetUserStatusRsp extends MessageMicro<ExtendFriendUserCategory$GetUserStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField Category = PBField.initEnum(0);
    public final PBBoolField UsedNewMatch = PBField.initBool(false);
    public final PBBoolField HasPersonalLabels = PBField.initBool(false);
    public ExtendFriendUserCategory$ForbiddenInfo forbiddenInfo = new MessageMicro<ExtendFriendUserCategory$ForbiddenInfo>() { // from class: tencent.im.usercategory.ExtendFriendUserCategory$ForbiddenInfo
        public static final int AddFrdOverFrequency = 5;
        public static final int BAETREASON_ADDFRDOVERFREQUENCY = 8;
        public static final int BAETREASON_GREETOVERFREQUENCY = 7;
        public static final int BAETREASON_HIGHRISKUSER = 9;
        public static final int BEATREASON_JUBAO = 1;
        public static final int BEATREASON_LENGGONG = 2;
        public static final int BEATREASON_LIAOTIANWEIGUI_QITA = 6;
        public static final int BEATREASON_LIAOTIANWEIGUI_SEQING = 3;
        public static final int BEATREASON_LIAOTIANWEIGUI_YINLIU = 5;
        public static final int BEATREASON_LIAOTIANWEIGUI_ZHAPIAN = 4;
        public static final int BEATREASON_UNKNOWN = 0;
        public static final int GreetOverFrequency = 4;
        public static final int HighRiskUser = 6;
        public static final int Jubao = 1;
        public static final int Lenggong = 2;
        public static final int NotSet = 0;
        public static final int SemanticBeat = 3;
        public static final int Sum = 1000000;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField isForbidden = PBField.initBool(false);
        public final PBUInt64Field forbiddenEndTime = PBField.initUInt64(0);
        public final PBUInt32Field forbiddenDuration = PBField.initUInt32(0);
        public final PBEnumField fobiddenType = PBField.initEnum(0);
        public final PBStringField fobiddenTips = PBField.initString("");
        public final PBEnumField beat_reason = PBField.initEnum(0);
        public ExtendFriendUserCategory$JubaoRecord jubao_record = new MessageMicro<ExtendFriendUserCategory$JubaoRecord>() { // from class: tencent.im.usercategory.ExtendFriendUserCategory$JubaoRecord
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"last_check_ts", "cnt_1year"}, new Object[]{0, 0}, ExtendFriendUserCategory$JubaoRecord.class);
            public final PBUInt32Field last_check_ts = PBField.initUInt32(0);
            public final PBUInt32Field cnt_1year = PBField.initUInt32(0);
        };
        public ExtendFriendUserCategory$LenggongRecord lenggong_record = new MessageMicro<ExtendFriendUserCategory$LenggongRecord>() { // from class: tencent.im.usercategory.ExtendFriendUserCategory$LenggongRecord
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"punish_times"}, new Object[]{0}, ExtendFriendUserCategory$LenggongRecord.class);
            public final PBUInt32Field punish_times = PBField.initUInt32(0);
        };
        public final PBBoolField hasFaceRealName = PBField.initBool(false);
        public final PBStringField faceAuthUrl = PBField.initString("");

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 82}, new String[]{"isForbidden", "forbiddenEndTime", "forbiddenDuration", "fobiddenType", "fobiddenTips", "beat_reason", "jubao_record", "lenggong_record", "hasFaceRealName", "faceAuthUrl"}, new Object[]{bool, 0L, 0, 0, "", 0, null, null, bool, ""}, ExtendFriendUserCategory$ForbiddenInfo.class);
        }
    };
    public final PBBoolField HasWangzheRecord = PBField.initBool(false);
    public final PBInt64Field LastLoginTime = PBField.initInt64(0);
    public final PBUInt32Field check_interval_ms = PBField.initUInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56}, new String[]{"Category", "UsedNewMatch", "HasPersonalLabels", "forbiddenInfo", "HasWangzheRecord", "LastLoginTime", "check_interval_ms"}, new Object[]{0, bool, bool, null, bool, 0L, 0}, ExtendFriendUserCategory$GetUserStatusRsp.class);
    }
}
