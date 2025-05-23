package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StRelationInfo extends MessageMicro<QZMomentMeta$StRelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430365id = PBField.initString("");
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBBoolField isUncare = PBField.initBool(false);
    public final PBBoolField hasRight = PBField.initBool(false);
    public final PBUInt64Field partFlag = PBField.initUInt64(0);

    static {
        String[] strArr = {"id", IProfileProtocolConst.PARAM_IS_FRIEND, "isUncare", "hasRight", "partFlag"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, strArr, new Object[]{"", bool, bool, bool, 0L}, QZMomentMeta$StRelationInfo.class);
    }
}
