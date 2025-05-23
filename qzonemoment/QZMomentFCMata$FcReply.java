package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentFCMata$FcReply extends MessageMicro<QZMomentFCMata$FcReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 74, 82}, new String[]{"userId", "ctime", "modifyFlag", "id", "targetUid", "content", "atuinList", "extendInfo", "likeKey", "atuinListAct"}, new Object[]{"", 0L, 0, "", "", "", "", null, "", ""}, QZMomentFCMata$FcReply.class);
    public final PBRepeatField<String> atuinList;
    public final PBRepeatField<String> atuinListAct;
    public QZMomentCommon$StCommonExt extendInfo;
    public final PBStringField likeKey;
    public final PBStringField userId = PBField.initString("");
    public final PBUInt64Field ctime = PBField.initUInt64(0);
    public final PBUInt32Field modifyFlag = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430360id = PBField.initString("");
    public final PBStringField targetUid = PBField.initString("");
    public final PBStringField content = PBField.initString("");

    public QZMomentFCMata$FcReply() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.atuinList = PBField.initRepeat(pBStringField);
        this.extendInfo = new QZMomentCommon$StCommonExt();
        this.likeKey = PBField.initString("");
        this.atuinListAct = PBField.initRepeat(pBStringField);
    }
}
