package qzonemoment;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StNotice extends MessageMicro<QZMomentMeta$StNotice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56}, new String[]{"id", "noticeType", QCircleDaTongConstant.ElementParamValue.OPERATION, WadlProxyConsts.CREATE_TIME, "content", "feed", "opMask"}, new Object[]{"", 0, null, 0L, null, null, 1}, QZMomentMeta$StNotice.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430364id = PBField.initString("");
    public final PBEnumField noticeType = PBField.initEnum(0);
    public QZMomentMeta$StOperation operation = new QZMomentMeta$StOperation();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public QZMomentMeta$StNoticeContent content = new QZMomentMeta$StNoticeContent();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
