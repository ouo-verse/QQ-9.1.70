package trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes30.dex */
public final class CommonOuterClass$PSKey extends MessageMicro<CommonOuterClass$PSKey> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField appid;
    public final PBBytesField pskey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pskey", "appid"}, new Object[]{byteStringMicro, byteStringMicro}, CommonOuterClass$PSKey.class);
    }

    public CommonOuterClass$PSKey() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pskey = PBField.initBytes(byteStringMicro);
        this.appid = PBField.initBytes(byteStringMicro);
    }
}
