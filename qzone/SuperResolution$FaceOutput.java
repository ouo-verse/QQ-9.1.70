package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$FaceOutput extends MessageMicro<SuperResolution$FaceOutput> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField face_bbox;
    public final PBUInt32Field face_id = PBField.initUInt32(0);
    public final PBBytesField face_url;
    public final PBBytesField inverse_matrix;
    public final PBBytesField mask_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"face_id", "face_url", "mask_url", "inverse_matrix", "face_bbox"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, SuperResolution$FaceOutput.class);
    }

    public SuperResolution$FaceOutput() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.face_url = PBField.initBytes(byteStringMicro);
        this.mask_url = PBField.initBytes(byteStringMicro);
        this.inverse_matrix = PBField.initBytes(byteStringMicro);
        this.face_bbox = PBField.initBytes(byteStringMicro);
    }
}
