package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearbybanner$ReqBody extends MessageMicro<nearbybanner$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_client_info", "msg_user_info"}, new Object[]{null, null}, nearbybanner$ReqBody.class);
    public nearbybanner$ClientInfo msg_client_info = new nearbybanner$ClientInfo();
    public nearbybanner$UserInfo msg_user_info = new MessageMicro<nearbybanner$UserInfo>() { // from class: tencent.im.group.nearbybanner.nearbybanner$UserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int64_longitude", "int64_latitude", "bytes_geocontent"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, nearbybanner$UserInfo.class);
        public final PBInt64Field int64_longitude = PBField.initInt64(0);
        public final PBInt64Field int64_latitude = PBField.initInt64(0);
        public final PBBytesField bytes_geocontent = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
