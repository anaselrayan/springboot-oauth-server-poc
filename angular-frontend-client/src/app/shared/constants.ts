
const code_verifier = 'ANAS-elrayan-CODE-verifier-random_code_test'
const code_challenge = 'oy7GOkd0WPmeMhKrjWVUWXEjgrJPEvsU8GsG7ralrkc'
const code_challenge_method = 'S256'

export const RESOURCE_URL = 'http://localhost:8080';
export const REDIRECT_URI = 'http://localhost:4200/authorized'
export const AUTH_ISSUER = 'http://localhost:9000'
export const AUTH_URL = `${AUTH_ISSUER}/oauth2/authorize?response_type=code&client_id=spa&scope=read&redirect_uri=${REDIRECT_URI}&code_challenge=${code_challenge}&code_challenge_method=${code_challenge_method}`
export const TOKEN_URL = `${AUTH_ISSUER}/oauth2/token?grant_type=authorization_code&redirect_uri=${REDIRECT_URI}&code_verifier=${code_verifier}`

