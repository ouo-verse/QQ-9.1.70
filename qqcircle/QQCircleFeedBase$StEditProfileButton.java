package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StEditProfileButton extends MessageMicro<QQCircleFeedBase$StEditProfileButton> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField guildInfo;
    public final PBBytesField profileBusiData;
    public final PBStringField title = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public FeedCloudMeta$StUser loginUser = new FeedCloudMeta$StUser();

    static {
        String[] strArr = {"title", WadlProxyConsts.KEY_JUMP_URL, "loginUser", "profileBusiData", "guildInfo"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, strArr, new Object[]{"", "", null, byteStringMicro, byteStringMicro}, QQCircleFeedBase$StEditProfileButton.class);
    }

    public QQCircleFeedBase$StEditProfileButton() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.profileBusiData = PBField.initBytes(byteStringMicro);
        this.guildInfo = PBField.initBytes(byteStringMicro);
    }
}
