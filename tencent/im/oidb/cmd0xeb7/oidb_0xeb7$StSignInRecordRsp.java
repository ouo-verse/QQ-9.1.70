package tencent.im.oidb.cmd0xeb7;

import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StSignInRecordRsp extends MessageMicro<oidb_0xeb7$StSignInRecordRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"ret", PM.BASE, "userRecord", "daySigned", "kingRecord", "level"}, new Object[]{null, null, null, null, null, null}, oidb_0xeb7$StSignInRecordRsp.class);
    public oidb_0xeb7$Ret ret = new oidb_0xeb7$Ret();
    public oidb_0xeb7$SignInStatusBase base = new oidb_0xeb7$SignInStatusBase();
    public oidb_0xeb7$StSignInRecordUser userRecord = new MessageMicro<oidb_0xeb7$StSignInRecordUser>() { // from class: tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInRecordUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 42, 50}, new String[]{"totalSignedDays", "earliestSignedTimeStamp", "continueSignedDays", "historySignedDays", "groupName"}, new Object[]{0, 0L, 0L, "", ""}, oidb_0xeb7$StSignInRecordUser.class);
        public final PBInt32Field totalSignedDays = PBField.initInt32(0);
        public final PBInt64Field earliestSignedTimeStamp = PBField.initInt64(0);
        public final PBInt64Field continueSignedDays = PBField.initInt64(0);
        public final PBRepeatField<String> historySignedDays = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField groupName = PBField.initString("");
    };
    public oidb_0xeb7$StSignInRecordDaySigned daySigned = new MessageMicro<oidb_0xeb7$StSignInRecordDaySigned>() { // from class: tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInRecordDaySigned
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 26, 34}, new String[]{"daySignedRatio", "dayTotalSignedUid", "daySignedPage", "daySignedUrl"}, new Object[]{Float.valueOf(0.0f), 0, null, ""}, oidb_0xeb7$StSignInRecordDaySigned.class);
        public final PBFloatField daySignedRatio = PBField.initFloat(0.0f);
        public final PBInt32Field dayTotalSignedUid = PBField.initInt32(0);
        public oidb_0xeb7$StDaySignedPage daySignedPage = new MessageMicro<oidb_0xeb7$StDaySignedPage>() { // from class: tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StDaySignedPage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"infos", "offset", "total"}, new Object[]{null, 0, 0}, oidb_0xeb7$StDaySignedPage.class);
            public final PBRepeatMessageField<oidb_0xeb7$StDaySignedInfo> infos = PBField.initRepeatMessage(oidb_0xeb7$StDaySignedInfo.class);
            public final PBInt32Field offset = PBField.initInt32(0);
            public final PBInt32Field total = PBField.initInt32(0);
        };
        public final PBStringField daySignedUrl = PBField.initString("");
    };
    public oidb_0xeb7$StSignInRecordKing kingRecord = new MessageMicro<oidb_0xeb7$StSignInRecordKing>() { // from class: tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInRecordKing
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"yesterdayFirst", "topSignedTotal", "topSignedContinue", "kingUrl"}, new Object[]{null, null, null, ""}, oidb_0xeb7$StSignInRecordKing.class);
        public oidb_0xeb7$StKingSignedInfo yesterdayFirst = new oidb_0xeb7$StKingSignedInfo();
        public final PBRepeatMessageField<oidb_0xeb7$StKingSignedInfo> topSignedTotal = PBField.initRepeatMessage(oidb_0xeb7$StKingSignedInfo.class);
        public final PBRepeatMessageField<oidb_0xeb7$StKingSignedInfo> topSignedContinue = PBField.initRepeatMessage(oidb_0xeb7$StKingSignedInfo.class);
        public final PBStringField kingUrl = PBField.initString("");
    };
    public oidb_0xeb7$StViewGroupLevel level = new MessageMicro<oidb_0xeb7$StViewGroupLevel>() { // from class: tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StViewGroupLevel
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "url"}, new Object[]{"", ""}, oidb_0xeb7$StViewGroupLevel.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField url = PBField.initString("");
    };
}
