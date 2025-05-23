package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$TryUpInfo4Busi extends MessageMicro<cmd0x388$TryUpInfo4Busi> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_down_url;
    public final PBBytesField bytes_down_domain;
    public final PBBytesField bytes_file_resid;
    public final PBBytesField bytes_original_down_url;
    public final PBBytesField bytes_thumb_down_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bytes_down_domain", "bytes_thumb_down_url", "bytes_original_down_url", "bytes_big_down_url", "bytes_file_resid"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, cmd0x388$TryUpInfo4Busi.class);
    }

    public cmd0x388$TryUpInfo4Busi() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_down_domain = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_down_url = PBField.initBytes(byteStringMicro);
        this.bytes_original_down_url = PBField.initBytes(byteStringMicro);
        this.bytes_big_down_url = PBField.initBytes(byteStringMicro);
        this.bytes_file_resid = PBField.initBytes(byteStringMicro);
    }
}
