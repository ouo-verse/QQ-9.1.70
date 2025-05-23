package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.tav.core.AssetExtension;

/* loaded from: classes29.dex */
public final class oidb_cmd0xf8b$Picture extends MessageMicro<oidb_cmd0xf8b$Picture> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field height;
    public final PBBytesField thumbnail;
    public final PBBytesField url;
    public final PBUInt32Field width;

    static {
        String[] strArr = {"url", "width", "height", AssetExtension.SCENE_THUMBNAIL};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, strArr, new Object[]{byteStringMicro, 0, 0, byteStringMicro}, oidb_cmd0xf8b$Picture.class);
    }

    public oidb_cmd0xf8b$Picture() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.url = PBField.initBytes(byteStringMicro);
        this.width = PBField.initUInt32(0);
        this.height = PBField.initUInt32(0);
        this.thumbnail = PBField.initBytes(byteStringMicro);
    }
}
