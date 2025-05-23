package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoBingeWatch$GetUserAlbumInfoData extends MessageMicro<TVideoBingeWatch$GetUserAlbumInfoData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_album_list"}, new Object[]{null}, TVideoBingeWatch$GetUserAlbumInfoData.class);
    public final PBRepeatMessageField<TVideoBingeWatch$UserAlbumInfo> user_album_list = PBField.initRepeatMessage(TVideoBingeWatch$UserAlbumInfo.class);
}
