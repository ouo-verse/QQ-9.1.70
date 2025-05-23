package unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UnifySearchCommon$ItemRequestUserData extends MessageMicro<UnifySearchCommon$ItemRequestUserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"rpt_busi_mask", QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA}, new Object[]{0L, ByteStringMicro.EMPTY}, UnifySearchCommon$ItemRequestUserData.class);
    public final PBUInt64Field rpt_busi_mask = PBField.initUInt64(0);
    public final PBBytesField user_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
