package tencent.im.ilive.photo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NowLiveGallary$ReqBody extends MessageMicro<NowLiveGallary$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"req_uin"}, new Object[]{0L}, NowLiveGallary$ReqBody.class);
    public final PBUInt64Field req_uin = PBField.initUInt64(0);
}
