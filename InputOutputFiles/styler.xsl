<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Decathlon Results</h2>
                <table border="1">
                    <tr bgcolor="grey">
                        <th>Ranked</th>
                        <th>Name</th>
                        <th>110m</th>
                        <th>Long Jump</th>
                        <th>Shot Put</th>
                        <th>High Jump</th>
                        <th>400m</th>
                        <th>110m Hurdles</th>
                        <th>Discus Throw</th>
                        <th>Pole Vault</th>
                        <th>Javelin Throw</th>
                        <th>1500m</th>
                        <th>Total Score</th>
                    </tr>
                    <xsl:for-each select="Results/Ranks">
                        <tr>
                            <td><xsl:value-of select="Ranked"/></td>
                            <td><xsl:value-of select="fullName"/></td>
                            <td><xsl:value-of select="m110"/></td>
                            <td><xsl:value-of select="longJump"/></td>
                            <td><xsl:value-of select="shotPut"/></td>
                            <td><xsl:value-of select="highJump"/></td>
                            <td><xsl:value-of select="m400"/></td>
                            <td><xsl:value-of select="m110Hurdles"/></td>
                            <td><xsl:value-of select="discusThrow"/></td>
                            <td><xsl:value-of select="poleVault"/></td>
                            <td><xsl:value-of select="javelinThrow"/></td>
                            <td><xsl:value-of select="m1500"/></td>
                            <td><xsl:value-of select="totalScore"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>