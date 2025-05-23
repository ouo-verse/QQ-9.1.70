package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentFCMata$FcComment extends MessageMicro<QZMomentFCMata$FcComment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 58, 66, 74, 82, 90}, new String[]{"userId", "ctime", "id", "modifyFlag", "content", "respNum", "reply", "atuinList", "extendInfo", "likeKey", "atuinListAct"}, new Object[]{"", 0L, "", 0, "", 0, null, "", null, "", ""}, QZMomentFCMata$FcComment.class);
    public final PBRepeatField<String> atuinList;
    public final PBRepeatField<String> atuinListAct;
    public QZMomentCommon$StCommonExt extendInfo;
    public final PBStringField likeKey;
    public final PBStringField userId = PBField.initString("");
    public final PBUInt64Field ctime = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430358id = PBField.initString("");
    public final PBUInt32Field modifyFlag = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field respNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<QZMomentFCMata$FcReply> reply = PBField.initRepeatMessage(QZMomentFCMata$FcReply.class);

    public QZMomentFCMata$FcComment() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.atuinList = PBField.initRepeat(pBStringField);
        this.extendInfo = new QZMomentCommon$StCommonExt();
        this.likeKey = PBField.initString("");
        this.atuinListAct = PBField.initRepeat(pBStringField);
    }
}
