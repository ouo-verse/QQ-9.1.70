package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$ImgInfo extends MessageMicro<CameraEmotionRoaming_sso$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_resource_id;
    public final PBRepeatField<ByteStringMicro> bytes_text;
    public final PBBytesField bytes_widget_id;
    public final PBBytesField url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bytes_resource_id", "bytes_text", "url", "bytes_md5", "bytes_widget_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, CameraEmotionRoaming_sso$ImgInfo.class);
    }

    public CameraEmotionRoaming_sso$ImgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resource_id = PBField.initBytes(byteStringMicro);
        this.bytes_text = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.url = PBField.initBytes(byteStringMicro);
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_widget_id = PBField.initBytes(byteStringMicro);
    }
}
