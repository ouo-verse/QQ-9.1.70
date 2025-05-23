package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$GetStarRedDotReq extends MessageMicro<GetStarRedDot$GetStarRedDotReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "white_uin"}, new Object[]{0, Boolean.FALSE}, GetStarRedDot$GetStarRedDotReq.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBoolField white_uin = PBField.initBool(false);
}
