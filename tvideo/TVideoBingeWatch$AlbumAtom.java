package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoBingeWatch$AlbumAtom extends MessageMicro<TVideoBingeWatch$AlbumAtom> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"cid", "vid", "video_time", "timestamp", "material_aspect_vid"}, new Object[]{"", "", 0, 0L, ""}, TVideoBingeWatch$AlbumAtom.class);
    public final PBStringField cid = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
    public final PBInt32Field video_time = PBField.initInt32(0);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBStringField material_aspect_vid = PBField.initString("");
}
