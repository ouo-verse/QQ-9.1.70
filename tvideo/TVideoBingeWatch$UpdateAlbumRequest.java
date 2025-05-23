package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoBingeWatch$UpdateAlbumRequest extends MessageMicro<TVideoBingeWatch$UpdateAlbumRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"option_type", "album_list", "source", "uid"}, new Object[]{0, null, "", ""}, TVideoBingeWatch$UpdateAlbumRequest.class);
    public final PBInt32Field option_type = PBField.initInt32(0);
    public final PBRepeatMessageField<TVideoBingeWatch$AlbumAtom> album_list = PBField.initRepeatMessage(TVideoBingeWatch$AlbumAtom.class);
    public final PBStringField source = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
}
