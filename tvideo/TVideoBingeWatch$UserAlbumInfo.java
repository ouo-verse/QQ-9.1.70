package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoBingeWatch$UserAlbumInfo extends MessageMicro<TVideoBingeWatch$UserAlbumInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField opened = PBField.initBool(false);
    public final PBBoolField is_user_album = PBField.initBool(false);
    public TVideoBingeWatch$AlbumAtom album_atom = new TVideoBingeWatch$AlbumAtom();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"opened", "is_user_album", "album_atom"}, new Object[]{bool, bool, null}, TVideoBingeWatch$UserAlbumInfo.class);
    }
}
