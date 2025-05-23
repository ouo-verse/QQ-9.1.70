package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoBingeWatch$GetUserAlbumInfoRequest extends MessageMicro<TVideoBingeWatch$GetUserAlbumInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cover_ids"}, new Object[]{""}, TVideoBingeWatch$GetUserAlbumInfoRequest.class);
    public final PBRepeatField<String> cover_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
