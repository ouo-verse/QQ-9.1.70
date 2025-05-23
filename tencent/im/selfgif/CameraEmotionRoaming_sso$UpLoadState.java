package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$UpLoadState extends MessageMicro<CameraEmotionRoaming_sso$UpLoadState> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_other;
    public final PBBytesField bytes_pic_version;
    public final PBBytesField bytes_resource_id;
    public final PBRepeatField<ByteStringMicro> bytes_text;
    public final PBBytesField bytes_widget_id;
    public final PBInt32Field int32_upload_state = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"int32_upload_state", "bytes_resource_id", "bytes_text", "bytes_pic_version", "bytes_other", "bytes_widget_id"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, CameraEmotionRoaming_sso$UpLoadState.class);
    }

    public CameraEmotionRoaming_sso$UpLoadState() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resource_id = PBField.initBytes(byteStringMicro);
        this.bytes_text = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.bytes_pic_version = PBField.initBytes(byteStringMicro);
        this.bytes_other = PBField.initBytes(byteStringMicro);
        this.bytes_widget_id = PBField.initBytes(byteStringMicro);
    }
}
